package com.facebook.stetho.inspector.protocol.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DOMStorage
  implements ChromeDevtoolsDomain
{
  private final Context mContext;
  private final DOMStoragePeerManager mDOMStoragePeerManager;
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  
  public DOMStorage(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDOMStoragePeerManager = new DOMStoragePeerManager(paramContext);
  }
  
  private static void assignByType(SharedPreferences.Editor paramEditor, String paramString, Object paramObject)
    throws IllegalArgumentException
  {
    if ((paramObject instanceof Integer))
    {
      paramEditor.putInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramEditor.putLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramEditor.putFloat(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramEditor.putString(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Set))
    {
      putStringSet(paramEditor, paramString, (Set)paramObject);
      return;
    }
    throw new IllegalArgumentException("Unsupported type=" + paramObject.getClass().getName());
  }
  
  @TargetApi(11)
  private static void putStringSet(SharedPreferences.Editor paramEditor, String paramString, Set<String> paramSet)
  {
    paramEditor.putStringSet(paramString, paramSet);
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mDOMStoragePeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mDOMStoragePeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getDOMStorageItems(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = (StorageId)this.mObjectMapper.convertValue(paramJSONObject.getJSONObject("storageId"), StorageId.class);
    paramJsonRpcPeer = new ArrayList();
    Object localObject = paramJSONObject.securityOrigin;
    if (paramJSONObject.isLocalStorage)
    {
      paramJSONObject = this.mContext.getSharedPreferences((String)localObject, 0).getAll().entrySet().iterator();
      while (paramJSONObject.hasNext())
      {
        localObject = (Map.Entry)paramJSONObject.next();
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(((Map.Entry)localObject).getKey());
        localArrayList.add(SharedPreferencesHelper.valueToString(((Map.Entry)localObject).getValue()));
        paramJsonRpcPeer.add(localArrayList);
      }
    }
    paramJSONObject = new GetDOMStorageItemsResult(null);
    paramJSONObject.entries = paramJsonRpcPeer;
    return paramJSONObject;
  }
  
  @ChromeDevtoolsMethod
  public void removeDOMStorageItem(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJsonRpcPeer = (StorageId)this.mObjectMapper.convertValue(paramJSONObject.getJSONObject("storageId"), StorageId.class);
    paramJSONObject = paramJSONObject.getString("key");
    if (paramJsonRpcPeer.isLocalStorage) {
      this.mContext.getSharedPreferences(paramJsonRpcPeer.securityOrigin, 0).edit().remove(paramJSONObject).apply();
    }
  }
  
  @ChromeDevtoolsMethod
  public void setDOMStorageItem(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws JSONException, JsonRpcException
  {
    paramJsonRpcPeer = (StorageId)this.mObjectMapper.convertValue(paramJSONObject.getJSONObject("storageId"), StorageId.class);
    String str = paramJSONObject.getString("key");
    paramJSONObject = paramJSONObject.getString("value");
    SharedPreferences localSharedPreferences;
    Object localObject;
    if (paramJsonRpcPeer.isLocalStorage)
    {
      localSharedPreferences = this.mContext.getSharedPreferences(paramJsonRpcPeer.securityOrigin, 0);
      localObject = localSharedPreferences.getAll().get(str);
      if (localObject == null)
      {
        try
        {
          throw new DOMStorageAssignmentException("Unsupported: cannot add new key " + str + " due to lack of type inference");
        }
        catch (DOMStorageAssignmentException localDOMStorageAssignmentException)
        {
          CLog.writeToConsole(this.mDOMStoragePeerManager, Console.MessageLevel.ERROR, Console.MessageSource.STORAGE, localDOMStorageAssignmentException.getMessage());
          if (!localSharedPreferences.contains(str)) {
            break label227;
          }
        }
        this.mDOMStoragePeerManager.signalItemUpdated(paramJsonRpcPeer, str, paramJSONObject, SharedPreferencesHelper.valueToString(localObject));
      }
    }
    else
    {
      return;
    }
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    try
    {
      assignByType(localEditor, str, SharedPreferencesHelper.valueFromString(paramJSONObject, localObject));
      localEditor.apply();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new DOMStorageAssignmentException(String.format(Locale.US, "Type mismatch setting %s to %s (expected %s)", new Object[] { str, paramJSONObject, localObject.getClass().getSimpleName() }));
    }
    label227:
    this.mDOMStoragePeerManager.signalItemRemoved(paramJsonRpcPeer, str);
  }
  
  static class DOMStorageAssignmentException
    extends Exception
  {
    public DOMStorageAssignmentException(String paramString)
    {
      super();
    }
  }
  
  public static class DomStorageItemAddedParams
  {
    @JsonProperty(required=true)
    public String key;
    @JsonProperty(required=true)
    public String newValue;
    @JsonProperty(required=true)
    public DOMStorage.StorageId storageId;
  }
  
  public static class DomStorageItemRemovedParams
  {
    @JsonProperty(required=true)
    public String key;
    @JsonProperty(required=true)
    public DOMStorage.StorageId storageId;
  }
  
  public static class DomStorageItemUpdatedParams
  {
    @JsonProperty(required=true)
    public String key;
    @JsonProperty(required=true)
    public String newValue;
    @JsonProperty(required=true)
    public String oldValue;
    @JsonProperty(required=true)
    public DOMStorage.StorageId storageId;
  }
  
  public static class DomStorageItemsClearedParams
  {
    @JsonProperty(required=true)
    public DOMStorage.StorageId storageId;
  }
  
  static class GetDOMStorageItemsResult
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<List<String>> entries;
  }
  
  public static class StorageId
  {
    @JsonProperty(required=true)
    public boolean isLocalStorage;
    @JsonProperty(required=true)
    public String securityOrigin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.DOMStorage
 * JD-Core Version:    0.7.0.1
 */