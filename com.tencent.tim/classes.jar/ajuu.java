import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajuu
{
  public final ArrayList<InterestTagInfo> tagInfos = new ArrayList(2);
  public final int tagType;
  
  public ajuu(int paramInt)
  {
    this.tagType = paramInt;
  }
  
  public static ajuu a(appoint_define.InterestTag paramInterestTag)
  {
    ajuu localajuu = null;
    if (paramInterestTag != null)
    {
      localajuu = new ajuu(paramInterestTag.uint32_tag_type.get());
      paramInterestTag = paramInterestTag.rpt_msg_tag_list.get();
      if ((paramInterestTag != null) && (paramInterestTag.size() > 0))
      {
        paramInterestTag = paramInterestTag.iterator();
        while (paramInterestTag.hasNext())
        {
          InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramInterestTag.next());
          if (localInterestTagInfo != null) {
            localajuu.tagInfos.add(localInterestTagInfo);
          }
        }
      }
    }
    return localajuu;
  }
  
  public static ajuu a(JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      ajuu localajuu;
      try
      {
        if (!paramJSONObject.has("tagType")) {
          break label123;
        }
        i = paramJSONObject.getInt("tagType");
        localajuu = new ajuu(i);
        if (!paramJSONObject.has("tagInfos")) {
          break label118;
        }
        paramJSONObject = paramJSONObject.getJSONArray("tagInfos");
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          break label114;
        }
        QLog.i("Q.nearby_people_card.", 2, paramJSONObject.toString());
      }
      Object localObject = localajuu;
      if (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(i);
        if (localObject != null)
        {
          localObject = InterestTagInfo.convertFrom((JSONObject)localObject);
          if (localObject != null)
          {
            localajuu.tagInfos.add(localObject);
            break label140;
            label114:
            localObject = null;
          }
        }
      }
      else
      {
        label118:
        label123:
        do
        {
          return localObject;
          paramJSONObject = null;
          break label128;
          i = 0;
          break;
          localObject = localajuu;
        } while (paramJSONObject == null);
        label128:
        i = j;
        continue;
      }
      label140:
      i += 1;
    }
  }
  
  public appoint_define.InterestTag a()
  {
    appoint_define.InterestTag localInterestTag = new appoint_define.InterestTag();
    localInterestTag.uint32_tag_type.set(this.tagType);
    if (this.tagInfos.size() > 0)
    {
      Iterator localIterator = this.tagInfos.iterator();
      while (localIterator.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)localIterator.next();
        if (localInterestTagInfo != null)
        {
          appoint_define.InterestItem localInterestItem = new appoint_define.InterestItem();
          localInterestItem.uint64_tag_id.set(localInterestTagInfo.tagId);
          if (localInterestTagInfo.tagName != null) {
            localInterestItem.str_tag_name.set(localInterestTagInfo.tagName);
          }
          if (localInterestTagInfo.tagBgColor != null) {
            localInterestItem.str_tag_back_color.set(localInterestTagInfo.tagBgColor);
          }
          if (localInterestTagInfo.tagTextColor != null) {
            localInterestItem.str_tag_font_color.set(localInterestTagInfo.tagTextColor);
          }
          if (localInterestTagInfo.tagJumpUrl != null) {
            localInterestItem.str_tag_href.set(localInterestTagInfo.tagJumpUrl);
          }
          if (localInterestTagInfo.tagIconUrl != null) {
            localInterestItem.str_tag_icon_url.set(localInterestTagInfo.tagIconUrl);
          }
          localInterestTag.rpt_msg_tag_list.add(localInterestItem);
        }
      }
    }
    return localInterestTag;
  }
  
  public JSONObject ac()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tagType", this.tagType);
      JSONArray localJSONArray = new JSONArray();
      if (this.tagInfos.size() > 0)
      {
        Iterator localIterator = this.tagInfos.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (InterestTagInfo)localIterator.next();
          if (localObject != null)
          {
            localObject = ((InterestTagInfo)localObject).convertTo();
            if (localObject != null) {
              localJSONArray.put(localObject);
            }
          }
        }
      }
      localException.put("tagInfos", localJSONArray);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, localException.toString());
      }
      return null;
    }
    return localException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (paramObject.getClass() != getClass());
      paramObject = (ajuu)paramObject;
    } while ((paramObject.tagType != this.tagType) || (paramObject.tagInfos.size() != this.tagInfos.size()));
    int j = this.tagInfos.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label94;
      }
      if (!aqft.equalsWithNullCheck(this.tagInfos.get(i), paramObject.tagInfos.get(i))) {
        break;
      }
      i += 1;
    }
    label94:
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[").append("tagType = ").append(this.tagType).append(",").append("size = ").append(this.tagInfos.size()).append(",");
    if (this.tagInfos.size() > 0)
    {
      Iterator localIterator = this.tagInfos.iterator();
      while (localIterator.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)localIterator.next();
        if (localInterestTagInfo != null) {
          localStringBuilder.append(localInterestTagInfo.toString()).append(",");
        }
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuu
 * JD-Core Version:    0.7.0.1
 */