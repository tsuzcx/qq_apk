import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgListHeadNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qaw
  extends ppu
{
  private String mSeq;
  private List<puh> nG;
  
  public qaw(@NonNull qqstory_service.RspMsgListHeadNode paramRspMsgListHeadNode)
  {
    super(paramRspMsgListHeadNode.result);
    this.mSeq = paramRspMsgListHeadNode.list_seq.get().toStringUtf8();
    this.nG = ao(paramRspMsgListHeadNode.node_list.get());
  }
  
  private static List<puh> ao(List<qqstory_service.MsgTabNodeInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qqstory_service.MsgTabNodeInfo localMsgTabNodeInfo = (qqstory_service.MsgTabNodeInfo)paramList.next();
      puh localpuh = new puh();
      localpuh.a(localMsgTabNodeInfo);
      localArrayList.add(localpuh);
    }
    return localArrayList;
  }
  
  public List<puh> bO()
  {
    return this.nG;
  }
  
  public String mH()
  {
    return this.mSeq;
  }
  
  public String toString()
  {
    return "RecentTabHaloResponse{mSeq='" + this.mSeq + '\'' + ", mMsgTabNodeInfos=" + this.nG + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qaw
 * JD-Core Version:    0.7.0.1
 */