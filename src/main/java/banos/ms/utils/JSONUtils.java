package banos.ms.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * [Author]			Mike Banos
 * [Date]			12/20/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		JSON utility methods.
 */
public class JSONUtils {
	/**
	 * Create the corresponding JSON string for an item.
	 * @param item The item to serialize.
	 * @return The serialized item.
	 * @throws JsonProcessingException
	 */
	public static<T> String toJson(T item) throws JsonProcessingException {
		return mapper.writeValueAsString(item);
	}
	
	/**
	 * Deserialize an object from a JSON string.
	 * @param serialized The JSON to deserialize.
	 * @param valueType The class type to deserialize to.
	 * @return The deserialized object.
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static<T> T fromJson(final String serialized, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(serialized, valueType); 
	}
	
	/**
	 * Deserialize an object from a JSON string.
	 * @param serialized The JSON to deserialize.
	 * @param valueTypeRef The class reference type to deserialize to.
	 * @return The deserialized object.
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static<T> T fromJson(final String serialized, TypeReference<T> valueTypeRef) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(serialized, valueTypeRef); 
	}
	
	private static final ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.registerModule(new JavaTimeModule());
	}
}
