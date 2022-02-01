import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.10;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.11;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.7;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.ReqBody;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.RspBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0x8f5.oidb_cmd0x8f5.ReqBody;
import tencent.im.oidb.cmd0x8f5.oidb_cmd0x8f5.RspBody;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.ChildChannelStatus;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.ReqBody;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.RspBody;
import tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsClearUnreadReq;
import tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsGetSubscribedListReq;
import tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsGetSubscribedListRsp;
import tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.ReqBody;
import tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.RspBody;

public class lho
  extends lir
{
  private int aPd;
  private int aPe;
  private boolean akj;
  private boolean akk;
  private LinkedHashMap<Integer, ChannelInfo> x = new LinkedHashMap();
  private LinkedHashMap<Integer, ChannelInfo> y = new LinkedHashMap();
  
  public lho(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void Z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("reqType")).intValue();
    paramToServiceMsg = new oidb_cmd0xd46.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ChannelInfoModule", 1, "[handle0xd46Resp] retCode :" + j + ", reqType : " + i);
    if (i == 2) {
      if ((j == 0) && (paramToServiceMsg.msg_ks_get_subscribed_list_rsp.has()) && (((oidb_cmd0xd46.KsGetSubscribedListRsp)paramToServiceMsg.msg_ks_get_subscribed_list_rsp.get()).bytes_ks_subscribed_list.has()))
      {
        paramToServiceMsg = ((oidb_cmd0xd46.KsGetSubscribedListRsp)paramToServiceMsg.msg_ks_get_subscribed_list_rsp.get()).bytes_ks_subscribed_list.get().toStringUtf8();
        QLog.d("ChannelInfoModule", 1, "getFollowListSubscribedList data : " + paramToServiceMsg);
        lcc.a().a(new lhp(this, j, paramToServiceMsg));
      }
    }
    while (i != 1) {
      for (;;)
      {
        return;
        paramToServiceMsg = "";
      }
    }
  }
  
  private void a(boolean paramBoolean1, List<ChannelInfo> paramList, List<Integer> paramList1, boolean paramBoolean2)
  {
    this.mMainThreadHandler.post(new ChannelInfoModule.5(this, paramBoolean1, paramBoolean2, paramList, paramList1));
  }
  
  private boolean a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (paramChannelInfo == null) {
      return false;
    }
    ChannelInfo localChannelInfo = paramChannelInfo.clone();
    this.x.put(Integer.valueOf(paramChannelInfo.mChannelID), localChannelInfo);
    if (paramBoolean) {
      this.mExecutorService.execute(new ChannelInfoModule.7(this, localChannelInfo));
    }
    return true;
  }
  
  private void aMq()
  {
    if (this.akk) {
      return;
    }
    Object localObject = this.mEntityManager.query(ChannelInfo.class, true, null, null, null, null, null, null);
    if (localObject == null)
    {
      this.akk = true;
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((ChannelInfo)((Iterator)localObject).next(), false);
    }
    this.akk = true;
  }
  
  private void g(Integer paramInteger)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.x.get(paramInteger);
    if (localChannelInfo != null)
    {
      this.x.remove(paramInteger);
      this.mExecutorService.execute(new ChannelInfoModule.6(this, localChannelInfo));
    }
  }
  
  public void N(int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt3));
    a(paramInt1, paramInt2, localArrayList, true, true);
  }
  
  public List<Integer> O(List<ChannelInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((ChannelInfo)paramList.next()).mChannelID));
    }
    return localArrayList;
  }
  
  protected void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  protected void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  protected void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    oidb_cmd0x69f.RspBody localRspBody = new oidb_cmd0x69f.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    label164:
    boolean bool;
    if (j == 0) {
      if (i == 1)
      {
        if (localRspBody.uint64_uin.has()) {
          localRspBody.uint64_uin.get();
        }
        if (localRspBody.rpt_channel_list.has())
        {
          paramObject = lum.S(localRspBody.rpt_channel_list.get());
          localObject1 = paramObject;
          paramFromServiceMsg = localObject2;
          if (localRspBody.rpt_uint32_my_channel_id_list.has())
          {
            localObject1 = paramObject;
            paramFromServiceMsg = localObject2;
            if (localRspBody.rpt_uint32_my_channel_id_list.get() != null)
            {
              paramFromServiceMsg = new ArrayList(localRspBody.rpt_uint32_my_channel_id_list.size());
              paramFromServiceMsg.addAll(localRspBody.rpt_uint32_my_channel_id_list.get());
              localObject1 = paramObject;
            }
          }
          if (localRspBody.uint32_channel_seq.has()) {
            this.aPe = localRspBody.uint32_channel_seq.get();
          }
          bool = true;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelInfoModule", 2, "handleGetChannelAndSubscribeList, result=" + j);
      }
      switch (((Integer)paramToServiceMsg.getAttributes().get(aff)).intValue())
      {
      default: 
        return;
      }
      a(bool, paramObject, paramFromServiceMsg, ((Boolean)paramToServiceMsg.getAttributes().get("debug")).booleanValue());
      return;
      paramObject = null;
      break;
      localObject1 = null;
      paramFromServiceMsg = localObject2;
      break label164;
      paramObject = null;
      bool = false;
      paramFromServiceMsg = localObject1;
    }
  }
  
  protected void Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public ChannelInfo a(Integer paramInteger)
  {
    aMq();
    return (ChannelInfo)this.x.get(paramInteger);
  }
  
  protected ToServiceMsg a(luq.c paramc)
  {
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(kxm.getAccount()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    if (paramc.aln) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_all_channel_list.set(1);
    }
    if (paramc.alo) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_my_channel_id_list.set(1);
    }
    if (paramc.alw) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_video_channel.set(1);
    }
    if (paramc.alx) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_local_channel_id.set(1);
    }
    if ((kxm.AI()) && (!paramc.debug))
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(1);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_word.set(1);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    }
    for (;;)
    {
      if (paramc.alv) {
        ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_recomm_channel.set(1);
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_important.set(paramc.aQa);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramc.aQb);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(paramc.aQc);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(paramc.aQd);
      localObject = lup.makeOIDBPkg("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).getAttributes().put(aff, Integer.valueOf(paramc.notifyType));
      ((ToServiceMsg)localObject).getAttributes().put("debug", Boolean.valueOf(paramc.debug));
      return localObject;
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, List<Integer> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new oidb_cmd0x908.ReqBody();
    ((oidb_cmd0x908.ReqBody)localObject).uint64_uin.set(Long.valueOf(kxm.getAccount()).longValue());
    ((oidb_cmd0x908.ReqBody)localObject).uint32_parent_channel_id.set(paramInt1);
    if (paramBoolean1)
    {
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_header_url.set(1);
      label54:
      if (!paramBoolean2) {
        break label183;
      }
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_subscription_count.set(1);
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        ((oidb_cmd0x908.ReqBody)localObject).rpt_child_channel_list.set(paramList);
      }
      localObject = lup.makeOIDBPkg("OidbSvc.0x908", 2312, 0, ((oidb_cmd0x908.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).getAttributes().put("channelType", Integer.valueOf(paramInt2));
      sendPbReq((ToServiceMsg)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChannelInfoModule", 2, String.format("getSubChannelStatus(): send 0x908 req, parentChannelID =%s , childChannelIDList=%s", new Object[] { Integer.valueOf(paramInt1), Arrays.toString(paramList.toArray()) }));
      return;
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_header_url.set(0);
      break label54;
      label183:
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_subscription_count.set(0);
    }
  }
  
  public boolean a(List<ChannelInfo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    Object localObject1 = new HashMap(paramList.size());
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChannelInfo)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(Integer.valueOf(((ChannelInfo)localObject3).mChannelID), localObject3);
    }
    localObject2 = new ArrayList();
    Object localObject3 = this.x.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject3).next();
      if (((HashMap)localObject1).get(localInteger) == null)
      {
        ((List)localObject2).add(localInteger);
        if (QLog.isColorLevel()) {
          QLog.e("ChannelInfoModule", 2, "saveAllChannelInfoList, channel deleted, channelID=" + localInteger + "channelName=" + ((ChannelInfo)this.x.get(localInteger)).mChannelName);
        }
      }
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      g((Integer)((Iterator)localObject1).next());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ChannelInfo)paramList.next();
      localObject2 = (ChannelInfo)this.x.get(Integer.valueOf(((ChannelInfo)localObject1).mChannelID));
      if (localObject2 == null)
      {
        a((ChannelInfo)localObject1, paramBoolean);
      }
      else if ((!((ChannelInfo)localObject2).mChannelName.equals(((ChannelInfo)localObject1).mChannelName)) || (((ChannelInfo)localObject2).mFontColor != ((ChannelInfo)localObject1).mFontColor) || (((ChannelInfo)localObject2).mFrameColor != ((ChannelInfo)localObject1).mFrameColor) || (!TextUtils.equals(((ChannelInfo)localObject2).mJumpUrl, ((ChannelInfo)localObject1).mJumpUrl)))
      {
        ((ChannelInfo)localObject2).mChannelName = ((ChannelInfo)localObject1).mChannelName;
        ((ChannelInfo)localObject2).mFontColor = ((ChannelInfo)localObject1).mFontColor;
        ((ChannelInfo)localObject2).mFrameColor = ((ChannelInfo)localObject1).mFrameColor;
        ((ChannelInfo)localObject2).mJumpUrl = ((ChannelInfo)localObject1).mJumpUrl;
        a((ChannelInfo)localObject2, paramBoolean);
      }
    }
    return true;
  }
  
  public void aEL()
  {
    this.akk = false;
    this.aPd = 0;
    this.x.clear();
    this.y.clear();
  }
  
  public List<ChannelInfo> aM()
  {
    aMq();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.x.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.x.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new lhq(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add((ChannelInfo)((Iterator)localObject1).next());
    }
    return localObject2;
  }
  
  public void aMp()
  {
    Object localObject = new oidb_cmd0xd46.ReqBody();
    ((oidb_cmd0xd46.ReqBody)localObject).uint32_oper_type.set(2);
    oidb_cmd0xd46.KsGetSubscribedListReq localKsGetSubscribedListReq = new oidb_cmd0xd46.KsGetSubscribedListReq();
    localKsGetSubscribedListReq.uint32_result_type.set(1);
    ((oidb_cmd0xd46.ReqBody)localObject).msg_ks_get_subscribed_list_req.set(localKsGetSubscribedListReq);
    localObject = lup.makeOIDBPkg("OidbSvc.0xd46", 3398, 0, ((oidb_cmd0xd46.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("reqType", Integer.valueOf(2));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void aMr()
  {
    nz(false);
  }
  
  public List<ChannelInfo> aN()
  {
    aMq();
    ArrayList localArrayList = new ArrayList(this.x.size());
    Iterator localIterator = this.x.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add((ChannelInfo)this.x.get(localInteger));
    }
    return localArrayList;
  }
  
  public List<Integer> aO()
  {
    aMq();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.x.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.x.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new lhr(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(Integer.valueOf(((ChannelInfo)((Iterator)localObject1).next()).mChannelID));
    }
    return localObject2;
  }
  
  public void aa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0x69e.RspBody()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      l(bool, (List)paramToServiceMsg.getAttributes().get("channelIDList"));
      return;
    }
  }
  
  public void ab(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0x8f5.RspBody());
    if (QLog.isColorLevel()) {
      QLog.e("ChannelInfoModule", 2, "handle0x8f5FollowUnfollow():  result = " + i);
    }
    this.mMainThreadHandler.post(new ChannelInfoModule.10(this, i));
  }
  
  public void ac(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    Object localObject = new oidb_cmd0x908.RspBody();
    int i = -1;
    int j = ((Integer)paramToServiceMsg.getAttributes().get("channelType")).intValue();
    int k = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    boolean bool1;
    if (k == 0)
    {
      if (((oidb_cmd0x908.RspBody)localObject).uint32_parent_channel_id.has()) {
        i = ((oidb_cmd0x908.RspBody)localObject).uint32_parent_channel_id.get();
      }
      if (!((oidb_cmd0x908.RspBody)localObject).rpt_child_channel_status_list.has()) {
        break label478;
      }
      paramFromServiceMsg = ((oidb_cmd0x908.RspBody)localObject).rpt_child_channel_status_list.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label478;
      }
      paramToServiceMsg = new SparseArray(paramFromServiceMsg.size());
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (oidb_cmd0x908.ChildChannelStatus)paramFromServiceMsg.next();
        if (paramObject != null)
        {
          localObject = new ChannelInfo();
          if (paramObject.uint32_status.has())
          {
            if (paramObject.uint32_status.get() > 0)
            {
              bool1 = true;
              label177:
              ((ChannelInfo)localObject).mIsFollowed = bool1;
            }
          }
          else
          {
            if (paramObject.uint32_subscription_count.has()) {
              ((ChannelInfo)localObject).mFollowNum = paramObject.uint32_subscription_count.get();
            }
            if ((paramObject.bytes_channel_header_url.has()) && (paramObject.bytes_channel_header_url.get() != null)) {
              ((ChannelInfo)localObject).mHeaderPicUrl = paramObject.bytes_channel_header_url.get().toStringUtf8();
            }
            if (paramObject.uint32_system_recomm.has())
            {
              if (paramObject.uint32_system_recomm.get() <= 0) {
                break label350;
              }
              bool1 = true;
              label264:
              ((ChannelInfo)localObject).mIsSystemRecomm = bool1;
            }
            if (paramObject.uint32_child_channel_id.has())
            {
              ((ChannelInfo)localObject).mChannelID = paramObject.uint32_child_channel_id.get();
              ((ChannelInfo)localObject).mChannelType = j;
              paramToServiceMsg.append(((ChannelInfo)localObject).mChannelID, localObject);
            }
            if (!paramObject.uint32_is_topic.has()) {
              continue;
            }
            if (paramObject.uint32_is_topic.get() <= 0) {
              break label356;
            }
          }
          label350:
          label356:
          for (bool1 = true;; bool1 = false)
          {
            ((ChannelInfo)localObject).mIsTopic = bool1;
            break;
            bool1 = false;
            break label177;
            bool1 = false;
            break label264;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg == null)
        {
          paramFromServiceMsg = "";
          QLog.d("ChannelInfoModule", 2, String.format("handle0x908GetChildChannelStatus(): parentChannelID = %s, childChannelType = %s, childChannelStatusArray = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramFromServiceMsg }));
        }
      }
      else
      {
        if (k != 0) {
          break label438;
        }
        bool1 = bool2;
        label420:
        b(bool1, i, paramToServiceMsg);
      }
      label438:
      do
      {
        return;
        paramFromServiceMsg = paramToServiceMsg.toString();
        break;
        bool1 = false;
        break label420;
      } while (!QLog.isColorLevel());
      QLog.e("ChannelInfoModule", 2, "handle0x908GetChildChannelStatus(): failed, result = " + k);
      return;
      label478:
      paramToServiceMsg = null;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      int j = paramSparseArray.size();
      int i = 0;
      while (i < j)
      {
        ChannelInfo localChannelInfo = (ChannelInfo)paramSparseArray.get(paramSparseArray.keyAt(i));
        if (localChannelInfo != null) {
          a(localChannelInfo, true);
        }
        i += 1;
      }
    }
    this.mMainThreadHandler.post(new ChannelInfoModule.11(this, paramBoolean, paramInt, paramSparseArray));
  }
  
  public void b(boolean paramBoolean, int paramInt, List<Integer> paramList)
  {
    oidb_cmd0x8f5.ReqBody localReqBody = new oidb_cmd0x8f5.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(kxm.getAccount()).longValue());
    if (paramBoolean)
    {
      localReqBody.enum_follow_op.set(0);
      localReqBody.uint32_parent_channel_id.set(paramInt);
      if ((paramList != null) && (paramList.size() > 0)) {
        localReqBody.rpt_child_channel_list.set(paramList);
      }
      sendPbReq(lup.makeOIDBPkg("OidbSvc.0x8f5", 2293, 0, localReqBody.toByteArray()));
      if (QLog.isColorLevel()) {
        if (paramList != null) {
          break label150;
        }
      }
    }
    label150:
    for (paramList = "null";; paramList = Arrays.toString(paramList.toArray()))
    {
      QLog.d("ChannelInfoModule", 2, String.format("followUnfollow(): send req, follow = %s, parentChannelID =%s , childChannelIDList=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
      return;
      localReqBody.enum_follow_op.set(1);
      break;
    }
  }
  
  protected void c(ChannelCoverInfo paramChannelCoverInfo)
  {
    if ((paramChannelCoverInfo != null) && (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelCoverName)) && (paramChannelCoverInfo.mChannelCoverName.contains("%#")))
    {
      String[] arrayOfString = paramChannelCoverInfo.mChannelCoverName.split("%#");
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        paramChannelCoverInfo.mChannelCoverName = arrayOfString[0];
      }
    }
  }
  
  public void c(ChannelInfo paramChannelInfo)
  {
    a(paramChannelInfo, true);
  }
  
  public void cr(List<Integer> paramList)
  {
    Object localObject = new oidb_cmd0x69e.ReqBody();
    ((oidb_cmd0x69e.ReqBody)localObject).rpt_uint32_channel_ids.set(paramList);
    localObject = lup.makeOIDBPkg("OidbSvc.0x69e", 1694, 0, ((oidb_cmd0x69e.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("channelIDList", paramList);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void cs(List<mgw> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Iterator localIterator = ((mgw)paramList.next()).iK.iterator();
      while (localIterator.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
        if (localTabChannelCoverInfo.mChannelCoverName.contains("%#"))
        {
          String[] arrayOfString = localTabChannelCoverInfo.mChannelCoverName.split("%#");
          if (!TextUtils.isEmpty(arrayOfString[0])) {
            localTabChannelCoverInfo.mChannelCoverName = arrayOfString[0];
          }
        }
      }
    }
  }
  
  protected void ct(List<ChannelCoverInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((ChannelCoverInfo)paramList.next());
      }
    }
  }
  
  public void cu(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (!this.akj) {
      return;
    }
    paramList = new ArrayList(paramList);
    paramList.remove(Integer.valueOf(9999));
    cv(paramList);
    cr(paramList);
    lcc.a().j(true, null);
  }
  
  public void cv(List<Integer> paramList)
  {
    int i = 0;
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.x.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = (ChannelInfo)this.x.get(localObject2);
        if (localObject2 != null)
        {
          ((ChannelInfo)localObject2).mShow = false;
          ((ChannelInfo)localObject2).mSortOrder = 0;
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int j = ((Integer)paramList.next()).intValue();
        localObject1 = (ChannelInfo)this.x.get(Integer.valueOf(j));
        if (localObject1 != null)
        {
          ((ChannelInfo)localObject1).mShow = true;
          ((ChannelInfo)localObject1).mSortOrder = i;
          i += 1;
        }
      }
      paramList = this.x.keySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Integer)paramList.next();
        localObject1 = (ChannelInfo)this.x.get(localObject1);
        if (localObject1 != null) {
          a((ChannelInfo)localObject1, true);
        }
      }
    }
  }
  
  public void g(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt2));
    b(paramBoolean, paramInt1, localArrayList);
  }
  
  public void l(boolean paramBoolean, List<Integer> paramList)
  {
    this.mMainThreadHandler.post(new ChannelInfoModule.4(this, paramBoolean, paramList));
  }
  
  public void nk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new oidb_cmd0xd46.ReqBody();
    ((oidb_cmd0xd46.ReqBody)localObject).uint32_oper_type.set(1);
    oidb_cmd0xd46.KsClearUnreadReq localKsClearUnreadReq = new oidb_cmd0xd46.KsClearUnreadReq();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramString));
    localKsClearUnreadReq.rpt_uint32_ks_topic_id_list.set(localArrayList);
    ((oidb_cmd0xd46.ReqBody)localObject).msg_ks_clear_unread_req.set(localKsClearUnreadReq);
    localObject = lup.makeOIDBPkg("OidbSvc.0xd46", 3398, 0, ((oidb_cmd0xd46.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("reqType", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("topid", paramString);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void nz(boolean paramBoolean)
  {
    Object localObject = new luq.c();
    ((luq.c)localObject).notifyType = 4;
    ((luq.c)localObject).aln = true;
    ((luq.c)localObject).alo = true;
    ((luq.c)localObject).alp = false;
    ((luq.c)localObject).alq = true;
    ((luq.c)localObject).alw = true;
    ((luq.c)localObject).alx = true;
    ((luq.c)localObject).alr = false;
    ((luq.c)localObject).als = false;
    ((luq.c)localObject).alt = false;
    ((luq.c)localObject).alu = false;
    ((luq.c)localObject).aQa = 1;
    ((luq.c)localObject).debug = paramBoolean;
    localObject = a((luq.c)localObject);
    ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(1));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public int oD()
  {
    List localList = aN();
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.mMainThreadHandler.post(new ChannelInfoModule.3(this, localList));
      return 0;
    }
    aMr();
    return 1;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69f")) {
      X(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69e"))
      {
        aa(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x908"))
      {
        ac(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8f5"))
      {
        ab(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbb"))
      {
        V(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbc"))
      {
        W(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbe6"))
      {
        Y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xd46"));
    Z(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lho
 * JD-Core Version:    0.7.0.1
 */