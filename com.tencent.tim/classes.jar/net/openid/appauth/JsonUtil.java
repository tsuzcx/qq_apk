package net.openid.appauth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class JsonUtil
{
  public static <T> T get(JSONObject paramJSONObject, Field<T> paramField)
  {
    try
    {
      if (!paramJSONObject.has(paramField.key)) {
        return paramField.defaultValue;
      }
      paramJSONObject = paramField.convert(paramJSONObject.getString(paramField.key));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("unexpected JSONException", paramJSONObject);
    }
  }
  
  public static <T> List<T> get(JSONObject paramJSONObject, ListField<T> paramListField)
  {
    try
    {
      if (!paramJSONObject.has(paramListField.key)) {
        return paramListField.defaultValue;
      }
      paramJSONObject = paramJSONObject.get(paramListField.key);
      if (!(paramJSONObject instanceof JSONArray)) {
        throw new IllegalStateException(paramListField.key + " does not contain the expected JSON array");
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("unexpected JSONException", paramJSONObject);
    }
    paramJSONObject = (JSONArray)paramJSONObject;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localArrayList.add(paramListField.convert(paramJSONObject.getString(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  @Nullable
  public static Long getLongIfDefined(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      return null;
    }
    return Long.valueOf(paramJSONObject.getLong(paramString));
  }
  
  @NonNull
  public static String getString(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      throw new JSONException("field \"" + paramString + "\" not found in json object");
    }
    paramJSONObject = paramJSONObject.getString(paramString);
    if (paramJSONObject == null) {
      throw new JSONException("field \"" + paramString + "\" is mapped to a null value");
    }
    return paramJSONObject;
  }
  
  public static String getStringIfDefined(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      paramJSONObject = null;
    }
    String str;
    do
    {
      return paramJSONObject;
      str = paramJSONObject.getString(paramString);
      paramJSONObject = str;
    } while (str != null);
    throw new JSONException("field \"" + paramString + "\" is mapped to a null value");
  }
  
  @NonNull
  public static List<String> getStringList(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      throw new JSONException("field \"" + paramString + "\" not found in json object");
    }
    return toStringList(paramJSONObject.getJSONArray(paramString));
  }
  
  public static List<String> getStringListIfDefined(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      return null;
    }
    paramJSONObject = paramJSONObject.getJSONArray(paramString);
    if (paramJSONObject == null) {
      throw new JSONException("field \"" + paramString + "\" is mapped to a null value");
    }
    return toStringList(paramJSONObject);
  }
  
  @NonNull
  public static Map<String, String> getStringMap(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      return localLinkedHashMap;
    }
    paramJSONObject = paramJSONObject.getJSONObject(paramString);
    paramString = paramJSONObject.keys();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      localLinkedHashMap.put(str, (String)Preconditions.checkNotNull(paramJSONObject.getString(str), "additional parameter values must not be null"));
    }
    return localLinkedHashMap;
  }
  
  public static Uri getUri(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    paramJSONObject = paramJSONObject.getString(paramString);
    if (paramJSONObject == null) {
      throw new JSONException("field \"" + paramString + "\" is mapped to a null value");
    }
    return Uri.parse(paramJSONObject);
  }
  
  @Nullable
  public static Uri getUriIfDefined(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      return null;
    }
    paramJSONObject = paramJSONObject.getString(paramString);
    if (paramJSONObject == null) {
      throw new JSONException("field \"" + paramString + "\" is mapped to a null value");
    }
    return Uri.parse(paramJSONObject);
  }
  
  @NonNull
  public static List<Uri> getUriList(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (!paramJSONObject.has(paramString)) {
      throw new JSONException("field \"" + paramString + "\" not found in json object");
    }
    return toUriList(paramJSONObject.getJSONArray(paramString));
  }
  
  @NonNull
  public static JSONObject mapToJsonObject(@NonNull Map<String, String> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Preconditions.checkNotNull(localEntry.getKey(), "map entries must not have null keys");
      Preconditions.checkNotNull(localEntry.getValue(), "map entries must not have null values");
      put(localJSONObject, (String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localJSONObject;
  }
  
  public static void put(@NonNull JSONObject paramJSONObject, @NonNull String paramString, @NonNull int paramInt)
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    Preconditions.checkNotNull(Integer.valueOf(paramInt), "value must not be null");
    try
    {
      paramJSONObject.put(paramString, paramInt);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract, ex");
    }
  }
  
  public static void put(@NonNull JSONObject paramJSONObject, @NonNull String paramString1, @NonNull String paramString2)
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString1, "field must not be null");
    Preconditions.checkNotNull(paramString2, "value must not be null");
    try
    {
      paramJSONObject.put(paramString1, paramString2);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject);
    }
  }
  
  public static void put(@NonNull JSONObject paramJSONObject, @NonNull String paramString, @NonNull JSONArray paramJSONArray)
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    Preconditions.checkNotNull(paramJSONArray, "value must not be null");
    try
    {
      paramJSONObject.put(paramString, paramJSONArray);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject);
    }
  }
  
  public static void put(@NonNull JSONObject paramJSONObject1, @NonNull String paramString, @NonNull JSONObject paramJSONObject2)
  {
    Preconditions.checkNotNull(paramJSONObject1, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    Preconditions.checkNotNull(paramJSONObject2, "value must not be null");
    try
    {
      paramJSONObject1.put(paramString, paramJSONObject2);
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject1);
    }
  }
  
  public static void putIfNotNull(@NonNull JSONObject paramJSONObject, @NonNull String paramString, @Nullable Uri paramUri)
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (paramUri == null) {
      return;
    }
    try
    {
      paramJSONObject.put(paramString, paramUri.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject);
    }
  }
  
  public static void putIfNotNull(@NonNull JSONObject paramJSONObject, @NonNull String paramString, @Nullable Long paramLong)
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (paramLong == null) {
      return;
    }
    try
    {
      paramJSONObject.put(paramString, paramLong);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject);
    }
  }
  
  public static void putIfNotNull(@NonNull JSONObject paramJSONObject, @NonNull String paramString1, @Nullable String paramString2)
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    Preconditions.checkNotNull(paramString1, "field must not be null");
    if (paramString2 == null) {
      return;
    }
    try
    {
      paramJSONObject.put(paramString1, paramString2);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject);
    }
  }
  
  public static void putIfNotNull(@NonNull JSONObject paramJSONObject1, @NonNull String paramString, @Nullable JSONObject paramJSONObject2)
  {
    Preconditions.checkNotNull(paramJSONObject1, "json must not be null");
    Preconditions.checkNotNull(paramString, "field must not be null");
    if (paramJSONObject2 == null) {
      return;
    }
    try
    {
      paramJSONObject1.put(paramString, paramJSONObject2);
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject1);
    }
  }
  
  @NonNull
  public static JSONArray toJsonArray(@NonNull Iterable<?> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable, "objects cannot be null");
    JSONArray localJSONArray = new JSONArray();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localJSONArray.put(paramIterable.next().toString());
    }
    return localJSONArray;
  }
  
  @NonNull
  public static List<String> toStringList(@Nullable JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(Preconditions.checkNotNull(paramJSONArray.get(i)).toString());
        i += 1;
      }
    }
    return localArrayList;
  }
  
  @NonNull
  public static List<Uri> toUriList(@Nullable JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(Uri.parse(Preconditions.checkNotNull(paramJSONArray.get(i)).toString()));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  static final class BooleanField
    extends JsonUtil.Field<Boolean>
  {
    BooleanField(String paramString, boolean paramBoolean)
    {
      super(Boolean.valueOf(paramBoolean));
    }
    
    Boolean convert(String paramString)
    {
      return Boolean.valueOf(Boolean.parseBoolean(paramString));
    }
  }
  
  static abstract class Field<T>
  {
    public final T defaultValue;
    public final String key;
    
    Field(String paramString, T paramT)
    {
      this.key = paramString;
      this.defaultValue = paramT;
    }
    
    abstract T convert(String paramString);
  }
  
  static abstract class ListField<T>
  {
    public final List<T> defaultValue;
    public final String key;
    
    ListField(String paramString, List<T> paramList)
    {
      this.key = paramString;
      this.defaultValue = paramList;
    }
    
    abstract T convert(String paramString);
  }
  
  static final class StringField
    extends JsonUtil.Field<String>
  {
    StringField(String paramString)
    {
      this(paramString, null);
    }
    
    StringField(String paramString1, String paramString2)
    {
      super(paramString2);
    }
    
    String convert(String paramString)
    {
      return paramString;
    }
  }
  
  static final class StringListField
    extends JsonUtil.ListField<String>
  {
    StringListField(String paramString)
    {
      super(null);
    }
    
    StringListField(String paramString, List<String> paramList)
    {
      super(paramList);
    }
    
    String convert(String paramString)
    {
      return paramString;
    }
  }
  
  static final class UriField
    extends JsonUtil.Field<Uri>
  {
    UriField(String paramString)
    {
      this(paramString, null);
    }
    
    UriField(String paramString, Uri paramUri)
    {
      super(paramUri);
    }
    
    Uri convert(String paramString)
    {
      return Uri.parse(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.JsonUtil
 * JD-Core Version:    0.7.0.1
 */