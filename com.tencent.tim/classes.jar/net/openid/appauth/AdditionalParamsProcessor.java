package net.openid.appauth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class AdditionalParamsProcessor
{
  static Set<String> builtInParams(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return Collections.emptySet();
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramVarArgs)));
  }
  
  static Map<String, String> checkAdditionalParams(@Nullable Map<String, String> paramMap, @NonNull Set<String> paramSet)
  {
    if (paramMap == null) {
      return Collections.emptyMap();
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      Preconditions.checkNotNull(str, "additional parameter keys cannot be null");
      Preconditions.checkNotNull(localObject, "additional parameter values cannot be null");
      if (!paramSet.contains(str)) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Parameter %s is directly supported via the authorization request builder, use the builder method instead", new Object[] { str });
        localLinkedHashMap.put(str, localObject);
        break;
      }
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static Map<String, String> extractAdditionalParams(Uri paramUri, Set<String> paramSet)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramUri.getQueryParameterNames().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramSet.contains(str)) {
        localLinkedHashMap.put(str, paramUri.getQueryParameter(str));
      }
    }
    return localLinkedHashMap;
  }
  
  static Map<String, String> extractAdditionalParams(JSONObject paramJSONObject, Set<String> paramSet)
    throws JSONException
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramSet.contains(str)) {
        localLinkedHashMap.put(str, paramJSONObject.get(str).toString());
      }
    }
    return localLinkedHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AdditionalParamsProcessor
 * JD-Core Version:    0.7.0.1
 */