import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class artm
  extends aryh
{
  public static final aryh.a<artm> a = new artn();
  public int ekT = -1;
  public List<Friend> friendList;
  public int groupId = -1;
  public String groupName = "";
  
  public static final List<artm> d(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("qqlist");
    int k = paramJSONObject.optInt("app_tid", -1);
    int m = paramJSONObject.optInt("app_rid", -1);
    int n = localJSONArray1.length();
    ArrayList localArrayList1 = new ArrayList(n);
    int i = 0;
    while (i < n)
    {
      JSONObject localJSONObject = localJSONArray1.getJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject.getJSONArray("data");
      int i1 = localJSONArray2.length();
      ArrayList localArrayList2 = new ArrayList(i1);
      int j = 0;
      if (j < i1)
      {
        Object localObject = localJSONArray2.getJSONObject(j);
        String str = ((JSONObject)localObject).getString("data");
        if (((JSONObject)localObject).has("nick"))
        {
          paramJSONObject = ((JSONObject)localObject).getString("nick");
          label129:
          if (!((JSONObject)localObject).has("label")) {
            break label216;
          }
        }
        label216:
        for (localObject = ((JSONObject)localObject).getString("label");; localObject = null)
        {
          Friend localFriend = new Friend();
          localFriend.openId = str;
          localFriend.nickName = arwx.qA(paramJSONObject);
          localFriend.label = arwx.qA((String)localObject);
          localFriend.ekR = m;
          localFriend.ekS = k;
          localArrayList2.add(localFriend);
          j += 1;
          break;
          paramJSONObject = null;
          break label129;
        }
      }
      paramJSONObject = new artm();
      paramJSONObject.groupId = i;
      paramJSONObject.groupName = arwx.qA(localJSONObject.getString("label"));
      paramJSONObject.friendList = localArrayList2;
      localArrayList1.add(paramJSONObject);
      i += 1;
    }
    return localArrayList1;
  }
  
  public static final List<artm> e(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("data");
    int m = localJSONArray1.length();
    int n = paramJSONObject.optInt("app_tid", -1);
    int i1 = paramJSONObject.optInt("app_rid", -1);
    ArrayList localArrayList1 = new ArrayList(m + 3);
    ArrayList localArrayList2 = new ArrayList();
    artm localartm = new artm();
    localartm.groupId = 0;
    localartm.groupName = acfp.m(2131706577);
    localartm.friendList = localArrayList2;
    localArrayList1.add(localartm);
    int j = 0;
    int i = 1;
    while (j < m)
    {
      JSONObject localJSONObject1 = localJSONArray1.getJSONObject(j);
      JSONArray localJSONArray2 = localJSONObject1.getJSONArray("friends");
      int i2 = localJSONArray2.length();
      ArrayList localArrayList3 = new ArrayList(i2);
      int k = 0;
      while (k < i2)
      {
        JSONObject localJSONObject2 = localJSONArray2.getJSONObject(k);
        if (localJSONObject2.getInt("unabled") == 1)
        {
          k += 1;
        }
        else
        {
          String str2 = localJSONObject2.getString("openid");
          if (localJSONObject2.has("nickname"))
          {
            localObject = localJSONObject2.getString("nickname");
            label202:
            if (!localJSONObject2.has("remark")) {
              break label307;
            }
          }
          label307:
          for (String str1 = localJSONObject2.getString("remark");; str1 = null)
          {
            Friend localFriend = new Friend();
            localFriend.openId = str2;
            localFriend.nickName = arwx.qA((String)localObject);
            localFriend.label = arwx.qA(str1);
            if (localJSONObject2.getInt("specified") == 1)
            {
              localFriend.ekR = i1;
              localFriend.ekS = n;
              localArrayList2.add(localFriend);
            }
            localArrayList3.add(localFriend);
            break;
            localObject = null;
            break label202;
          }
        }
      }
      Object localObject = new artm();
      ((artm)localObject).groupId = i;
      ((artm)localObject).groupName = arwx.qA(localJSONObject1.getString("groupname"));
      ((artm)localObject).friendList = localArrayList3;
      localArrayList1.add(localObject);
      j += 1;
      i += 1;
    }
    if (paramJSONObject.getInt("only") == 1)
    {
      paramJSONObject = new ArrayList(1);
      paramJSONObject.add(localartm);
      return paramJSONObject;
    }
    if (localArrayList2.size() == 0)
    {
      localArrayList1.remove(0);
      i = 0;
      while (i < localArrayList1.size())
      {
        paramJSONObject = (artm)localArrayList1.get(i);
        paramJSONObject.groupId -= 1;
        i += 1;
      }
    }
    return localArrayList1;
  }
  
  public static final List<artm> f(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("qqlist");
    int m = localJSONArray1.length();
    int n = paramJSONObject.optInt("app_tid", -1);
    int i1 = paramJSONObject.optInt("app_rid", -1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    artm localartm2 = new artm();
    localartm2.groupId = 0;
    localartm2.groupName = acfp.m(2131706576);
    localartm2.friendList = localArrayList2;
    localArrayList1.add(localartm2);
    int i = 0;
    artm localartm1 = null;
    int j = 1;
    if (i < m)
    {
      JSONObject localJSONObject1 = localJSONArray1.getJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject1.getJSONArray("data");
      int i2 = localJSONArray2.length();
      ArrayList localArrayList3 = new ArrayList();
      int k = 0;
      Object localObject;
      if (k < i2)
      {
        JSONObject localJSONObject2 = localJSONArray2.getJSONObject(k);
        String str2 = localJSONObject2.getString("data");
        if (localJSONObject2.has("nick"))
        {
          localObject = localJSONObject2.getString("nick");
          label181:
          if (!localJSONObject2.has("label")) {
            break label294;
          }
        }
        label294:
        for (String str1 = localJSONObject2.getString("label");; str1 = null)
        {
          Friend localFriend = new Friend();
          localFriend.openId = str2;
          localFriend.nickName = ((String)localObject);
          localFriend.label = str1;
          if ((localJSONObject2.getInt("specified") == 1) && (!localArrayList2.contains(localFriend)))
          {
            localFriend.ekR = i1;
            localFriend.ekS = n;
            localArrayList2.add(localFriend);
          }
          localArrayList3.add(localFriend);
          k += 1;
          break;
          localObject = null;
          break label181;
        }
      }
      if (acfp.m(2131706575).equals(localJSONObject1.getString("label")))
      {
        localartm1 = new artm();
        localartm1.groupId = 0;
        localartm1.groupName = arwx.qA(localJSONObject1.getString("label"));
        localartm1.friendList = localArrayList3;
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = new artm();
        ((artm)localObject).groupId = j;
        ((artm)localObject).groupName = arwx.qA(localJSONObject1.getString("label"));
        ((artm)localObject).friendList = localArrayList3;
        localArrayList1.add(localObject);
        j += 1;
      }
    }
    if (paramJSONObject.getInt("only") == 1)
    {
      paramJSONObject = new ArrayList();
      paramJSONObject.add(localartm2);
      return paramJSONObject;
    }
    if (localArrayList2.size() == 0)
    {
      if ((localartm1 == null) || (localartm1.friendList == null) || (localartm1.friendList.size() <= 0)) {
        break label493;
      }
      localArrayList1.remove(0);
      localArrayList1.add(0, localartm1);
    }
    for (;;)
    {
      return localArrayList1;
      label493:
      localArrayList1.remove(0);
      i = 0;
      while (i < localArrayList1.size())
      {
        paramJSONObject = (artm)localArrayList1.get(i);
        paramJSONObject.groupId -= 1;
        i += 1;
      }
    }
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.groupId = paramParcel.readInt();
    this.groupName = paramParcel.readString();
    this.friendList = new ArrayList();
    paramParcel.readTypedList(this.friendList, Friend.CREATOR);
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("data", arrayOfByte);
    paramContentValues.put("groupId", Integer.valueOf(this.groupId));
  }
  
  public void writeToParcel(Parcel paramParcel)
  {
    paramParcel.writeInt(this.groupId);
    paramParcel.writeString(this.groupName);
    paramParcel.writeTypedList(this.friendList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artm
 * JD-Core Version:    0.7.0.1
 */