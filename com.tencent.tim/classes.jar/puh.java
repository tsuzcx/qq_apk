import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class puh
  implements plu
{
  public boolean aBG;
  public String ava = "";
  public String avv = "";
  public int bkt;
  public long cacheSeq;
  public boolean firstExp = true;
  public String headerUrl;
  public List<pux> iO = new ArrayList();
  public long id;
  public boolean isUploading;
  public String jumpUrl;
  public List<qej> mC;
  public int noUpdate;
  public String nodeFeedId;
  public long nodeInfoTimeStamp;
  public int nodePosition;
  public int nodeType;
  public String nodeVid;
  public String passthrough;
  public String recommandNameIconUrl;
  public long recommendId;
  public boolean redPoint;
  public long reqTimeStamp;
  public int source;
  public String title;
  public long uid;
  public String unionId;
  public int unreadCount;
  public String videoCover;
  public int videoCoverType;
  
  public puh() {}
  
  public puh(int paramInt, String paramString)
  {
    this.nodeType = paramInt;
    this.unionId = paramString;
  }
  
  public boolean Ja()
  {
    Iterator localIterator = this.iO.iterator();
    while (localIterator.hasNext())
    {
      pux localpux = (pux)localIterator.next();
      if ((TextUtils.isEmpty(localpux.vid)) || (TextUtils.isEmpty(localpux.feedId))) {
        return false;
      }
    }
    if (!this.iO.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public long N(String paramString)
  {
    try
    {
      Object[] arrayOfObject = this.iO.toArray();
      if (arrayOfObject != null)
      {
        int j = arrayOfObject.length;
        i = 0;
        if (i < j)
        {
          pux localpux = (pux)arrayOfObject[i];
          if (TextUtils.equals(paramString, localpux.vid)) {
            return localpux.Av;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        ram.e("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "getRecommendIdByVid:%s", localException);
        Object localObject = null;
        continue;
        i += 1;
      }
    }
    return 0L;
  }
  
  public MsgTabNodeEntity a()
  {
    MsgTabNodeEntity localMsgTabNodeEntity = new MsgTabNodeEntity();
    localMsgTabNodeEntity.nodeType = this.nodeType;
    localMsgTabNodeEntity.uid = this.uid;
    localMsgTabNodeEntity.unionId = this.unionId;
    localMsgTabNodeEntity.nodeVid = this.nodeVid;
    localMsgTabNodeEntity.nodeFeedId = this.nodeFeedId;
    localMsgTabNodeEntity.title = this.title;
    localMsgTabNodeEntity.headUrl = this.headerUrl;
    localMsgTabNodeEntity.recommendId = this.recommendId;
    localMsgTabNodeEntity.jumpUrl = this.jumpUrl;
    localMsgTabNodeEntity.nodePosition = this.nodePosition;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.iO.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((pux)localIterator.next()).toJson());
    }
    localMsgTabNodeEntity.videoInfoList = localJSONArray.toString();
    localMsgTabNodeEntity.reqTimeStamp = this.reqTimeStamp;
    localMsgTabNodeEntity.nodeInfoTimeStamp = this.nodeInfoTimeStamp;
    localMsgTabNodeEntity.videoCover = this.videoCover;
    if (this.mC != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.mC.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((qej)localIterator.next()).toJson());
      }
      localMsgTabNodeEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabNodeEntity.recommandNameIconUrl = this.recommandNameIconUrl;
    localMsgTabNodeEntity.cacheSeq = this.cacheSeq;
    localMsgTabNodeEntity.passthrough = this.passthrough;
    localMsgTabNodeEntity.redPoint = this.redPoint;
    return localMsgTabNodeEntity;
  }
  
  public MsgTabHaloEntity a()
  {
    MsgTabHaloEntity localMsgTabHaloEntity = new MsgTabHaloEntity();
    localMsgTabHaloEntity.nodeType = this.nodeType;
    localMsgTabHaloEntity.uid = this.uid;
    localMsgTabHaloEntity.unionId = this.unionId;
    localMsgTabHaloEntity.nodeVid = this.nodeVid;
    localMsgTabHaloEntity.title = this.title;
    localMsgTabHaloEntity.headUrl = this.headerUrl;
    localMsgTabHaloEntity.recommendId = this.recommendId;
    localMsgTabHaloEntity.jumpUrl = this.jumpUrl;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.iO.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((pux)localIterator.next()).toJson());
    }
    localMsgTabHaloEntity.videoInfoList = localJSONArray.toString();
    localMsgTabHaloEntity.reqTimeStamp = this.reqTimeStamp;
    localMsgTabHaloEntity.nodeInfoTimeStamp = this.nodeInfoTimeStamp;
    localMsgTabHaloEntity.videoCover = this.videoCover;
    if (this.mC != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.mC.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((qej)localIterator.next()).toJson());
      }
      localMsgTabHaloEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabHaloEntity.noUpdate = this.noUpdate;
    return localMsgTabHaloEntity;
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    int j = 0;
    this.nodeType = paramMsgTabNodeEntity.nodeType;
    this.uid = paramMsgTabNodeEntity.uid;
    this.unionId = paramMsgTabNodeEntity.unionId;
    this.title = paramMsgTabNodeEntity.title;
    this.headerUrl = paramMsgTabNodeEntity.headUrl;
    this.recommendId = paramMsgTabNodeEntity.recommendId;
    this.jumpUrl = paramMsgTabNodeEntity.jumpUrl;
    this.nodeVid = paramMsgTabNodeEntity.nodeVid;
    this.nodeFeedId = paramMsgTabNodeEntity.nodeFeedId;
    this.videoCover = paramMsgTabNodeEntity.videoCover;
    this.nodePosition = paramMsgTabNodeEntity.nodePosition;
    this.iO = new ArrayList();
    this.unreadCount = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabNodeEntity.videoInfoList);
      int k = localJSONArray1.length();
      i = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (i < k)
      {
        localJSONObject = localJSONArray1.getJSONObject(i);
        localObject = new pux();
        ((pux)localObject).ak(localJSONObject);
        this.iO.add(localObject);
        if (!((pux)localObject).aBR) {
          this.unreadCount += 1;
        }
        i += 1;
      }
      JSONArray localJSONArray2;
      if (this.nodeType == 11) {
        break label360;
      }
    }
    catch (JSONException localJSONException1)
    {
      ram.e("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "convertFrom(entity) errors", localJSONException1);
      this.reqTimeStamp = paramMsgTabNodeEntity.reqTimeStamp;
      this.nodeInfoTimeStamp = paramMsgTabNodeEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabNodeEntity.localSuccessVideoList)) && (!paramMsgTabNodeEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabNodeEntity.localSuccessVideoList);
          this.mC = new ArrayList();
          k = localJSONArray2.length();
          i = 0;
          while (i < k)
          {
            localJSONObject = localJSONArray2.getJSONObject(i);
            localObject = new qej();
            ((qej)localObject).ak(localJSONObject);
            this.mC.add(localObject);
            i += 1;
          }
          if (this.nodeType == 10) {
            break label360;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    if (this.nodeType == 3) {
      label360:
      if (!puy.h(this)) {
        break label423;
      }
    }
    label423:
    for (int i = j;; i = 1)
    {
      this.unreadCount = i;
      this.recommandNameIconUrl = paramMsgTabNodeEntity.recommandNameIconUrl;
      this.cacheSeq = paramMsgTabNodeEntity.cacheSeq;
      this.passthrough = paramMsgTabNodeEntity.passthrough;
      this.redPoint = paramMsgTabNodeEntity.redPoint;
      this.videoCoverType = paramMsgTabNodeEntity.videoCoverType;
      this.firstExp = paramMsgTabNodeEntity.firstExp;
      return;
    }
  }
  
  public void a(MsgTabHaloEntity paramMsgTabHaloEntity)
  {
    int j = 0;
    this.nodeType = paramMsgTabHaloEntity.nodeType;
    this.uid = paramMsgTabHaloEntity.uid;
    this.unionId = paramMsgTabHaloEntity.unionId;
    this.title = paramMsgTabHaloEntity.title;
    this.headerUrl = paramMsgTabHaloEntity.headUrl;
    this.recommendId = paramMsgTabHaloEntity.recommendId;
    this.jumpUrl = paramMsgTabHaloEntity.jumpUrl;
    this.nodeVid = paramMsgTabHaloEntity.nodeVid;
    this.videoCover = paramMsgTabHaloEntity.videoCover;
    this.iO = new ArrayList();
    this.unreadCount = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabHaloEntity.videoInfoList);
      int k = localJSONArray1.length();
      i = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (i < k)
      {
        localJSONObject = localJSONArray1.getJSONObject(i);
        localObject = new pux();
        ((pux)localObject).ak(localJSONObject);
        this.iO.add(localObject);
        if (!((pux)localObject).aBR) {
          this.unreadCount += 1;
        }
        i += 1;
      }
      JSONArray localJSONArray2;
      if (this.nodeType == 11) {
        break label340;
      }
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      this.reqTimeStamp = paramMsgTabHaloEntity.reqTimeStamp;
      this.nodeInfoTimeStamp = paramMsgTabHaloEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabHaloEntity.localSuccessVideoList)) && (!paramMsgTabHaloEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabHaloEntity.localSuccessVideoList);
          this.mC = new ArrayList();
          k = localJSONArray2.length();
          i = 0;
          while (i < k)
          {
            localJSONObject = localJSONArray2.getJSONObject(i);
            localObject = new qej();
            ((qej)localObject).ak(localJSONObject);
            this.mC.add(localObject);
            i += 1;
          }
          if (this.nodeType == 10) {
            break label340;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    if (this.nodeType == 3) {
      label340:
      if (!puy.h(this)) {
        break label368;
      }
    }
    label368:
    for (int i = j;; i = 1)
    {
      this.unreadCount = i;
      this.noUpdate = paramMsgTabHaloEntity.noUpdate;
      this.source = 1;
      return;
    }
  }
  
  public void a(qqstory_service.MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.nodeType = paramMsgTabNodeInfo.uint32_node_type.get();
    this.uid = paramMsgTabNodeInfo.uint64_uid.get();
    this.unionId = paramMsgTabNodeInfo.bytes_union_id.get().toStringUtf8();
    this.iO = new ArrayList(paramMsgTabNodeInfo.rpt_msg_video_info_list.size());
    this.unreadCount = 0;
    ArrayDeque localArrayDeque = new ArrayDeque(3);
    Iterator localIterator = paramMsgTabNodeInfo.rpt_msg_video_info_list.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_service.MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (qqstory_service.MsgTabNodeVideoInfo)localIterator.next();
      pux localpux = new pux();
      localpux.a(localMsgTabNodeVideoInfo, localArrayDeque);
      this.iO.add(localpux);
      if (!localpux.aBR) {
        this.unreadCount += 1;
      }
    }
    this.reqTimeStamp = paramMsgTabNodeInfo.uint64_req_time_stamp.get();
    this.nodeInfoTimeStamp = paramMsgTabNodeInfo.uint64_node_info_time_stamp.get();
    this.recommendId = paramMsgTabNodeInfo.recommend_id.get();
    if (paramMsgTabNodeInfo.bytes_title.has()) {
      this.title = paramMsgTabNodeInfo.bytes_title.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.bytes_icon_url.has()) {
      this.headerUrl = paramMsgTabNodeInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.link_url.has()) {
      this.jumpUrl = paramMsgTabNodeInfo.link_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_vid.has()) {
      this.nodeVid = paramMsgTabNodeInfo.node_vid.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.video_cover.has()) {
      this.videoCover = paramMsgTabNodeInfo.video_cover.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_position.has()) {
      this.nodePosition = paramMsgTabNodeInfo.node_position.get();
    }
    if ((this.nodeType == 10) || (this.nodeType == 11) || (this.nodeType == 3)) {
      if (!puy.h(this)) {
        break label603;
      }
    }
    label603:
    for (int i = 0;; i = 1)
    {
      this.unreadCount = i;
      if ((this.nodeType == 12) && (paramMsgTabNodeInfo.rpt_msg_video_info_list.size() > 0))
      {
        this.nodeVid = ((qqstory_service.MsgTabNodeVideoInfo)paramMsgTabNodeInfo.rpt_msg_video_info_list.get(0)).vid.get().toStringUtf8();
        this.nodeFeedId = ((qqstory_service.MsgTabNodeVideoInfo)paramMsgTabNodeInfo.rpt_msg_video_info_list.get(0)).feed_id.get().toStringUtf8();
      }
      this.noUpdate = paramMsgTabNodeInfo.no_update.get();
      if (paramMsgTabNodeInfo.recommend_name_icon.has()) {
        this.recommandNameIconUrl = paramMsgTabNodeInfo.recommend_name_icon.get().toStringUtf8();
      }
      if (paramMsgTabNodeInfo.uint64_cache_seq.has()) {
        this.cacheSeq = paramMsgTabNodeInfo.uint64_cache_seq.get();
      }
      if (paramMsgTabNodeInfo.passthrough.has()) {
        this.passthrough = paramMsgTabNodeInfo.passthrough.get().toStringUtf8();
      }
      if (paramMsgTabNodeInfo.redpoint.has())
      {
        this.redPoint = paramMsgTabNodeInfo.redpoint.get();
        ram.a("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "MsgTabNodeInfo convertFrom, unionId:%s, uid:%s, redPoint:%s", this.unionId, Long.valueOf(this.uid), Boolean.valueOf(this.redPoint));
      }
      if (paramMsgTabNodeInfo.video_cover_type.has()) {
        this.videoCoverType = paramMsgTabNodeInfo.video_cover_type.get();
      }
      if (this.nodeType == 13) {
        puy.a(QQStoryContext.a()).l(this);
      }
      return;
    }
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof puh))
    {
      paramObject = (puh)paramObject;
      this.nodeType = paramObject.nodeType;
      this.uid = paramObject.uid;
      this.unionId = paramObject.unionId;
      this.iO = new ArrayList(paramObject.iO);
      this.aBG = paramObject.aBG;
      this.reqTimeStamp = paramObject.reqTimeStamp;
      this.nodeInfoTimeStamp = paramObject.nodeInfoTimeStamp;
      this.unreadCount = paramObject.unreadCount;
      this.recommendId = paramObject.recommendId;
      this.headerUrl = paramObject.headerUrl;
      this.title = paramObject.title;
      this.jumpUrl = paramObject.jumpUrl;
      this.nodeVid = paramObject.nodeVid;
      this.nodeFeedId = paramObject.nodeFeedId;
      this.bkt = paramObject.bkt;
      this.isUploading = paramObject.isUploading;
      this.mC = paramObject.mC;
      this.avv = paramObject.avv;
      this.nodePosition = paramObject.nodePosition;
      this.noUpdate = paramObject.noUpdate;
      this.ava = paramObject.ava;
      this.recommandNameIconUrl = paramObject.recommandNameIconUrl;
      this.cacheSeq = paramObject.cacheSeq;
      this.passthrough = paramObject.passthrough;
      this.redPoint = paramObject.redPoint;
      this.videoCoverType = paramObject.videoCoverType;
      this.firstExp = paramObject.firstExp;
    }
  }
  
  public void e(puh parampuh)
  {
    this.bkt = parampuh.bkt;
    this.isUploading = parampuh.isUploading;
    this.avv = parampuh.avv;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof puh)) {
        return false;
      }
      paramObject = (puh)paramObject;
      if (this.nodeType != paramObject.nodeType) {
        return false;
      }
      if (this.unionId != null) {
        return this.unionId.equals(paramObject.unionId);
      }
    } while (paramObject.unionId == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = this.nodeType;
    if (this.unionId != null) {}
    for (int i = this.unionId.hashCode();; i = 0) {
      return i + (j + 629) * 37;
    }
  }
  
  public int sz()
  {
    if (this.isUploading) {
      return 1;
    }
    if (this.bkt > 0) {
      return 2;
    }
    return 0;
  }
  
  public String toString()
  {
    return "MsgTabNodeInfo{nodeType=" + this.nodeType + ", title='" + this.title + '\'' + ", uid=" + this.uid + ", unionId='" + this.unionId + '\'' + ", unreadCount=" + this.unreadCount + ", nodePosition=" + this.nodePosition + ", videoInfoList.size=" + this.iO.size() + ", nodeVid='" + this.nodeVid + '\'' + ", nodeFeedId='" + this.nodeFeedId + '\'' + ", reqTimeStamp=" + this.reqTimeStamp + ", nodeInfoTimeStamp=" + this.nodeInfoTimeStamp + ", unUploadVideoCount=" + this.bkt + ", id=" + this.id + ", noUpdate=" + this.noUpdate + '\'' + ", recommendId=" + this.recommendId + ", isUploading=" + this.isUploading + ", headerUrl='" + this.headerUrl + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", videoCover='" + this.videoCover + '\'' + ", uploadingCover=" + this.avv + ", recommandNameIconUrl=" + this.recommandNameIconUrl + ", cacheSeq='" + this.cacheSeq + '\'' + ", passthrough=" + this.passthrough + ", redPoint=" + this.redPoint + ", videoCoverType=" + this.videoCoverType + ", firstExp=" + this.firstExp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puh
 * JD-Core Version:    0.7.0.1
 */