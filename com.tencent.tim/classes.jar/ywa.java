import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class ywa
  extends auvp
{
  private yru a;
  private View.OnClickListener eo = new ywb(this);
  private List<MessageRecord> fC = new ArrayList();
  protected SlideDetectListView g;
  private QQAppInterface mApp;
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  public List<MessageRecord> tu = new ArrayList();
  public int unreadMsgNum;
  
  public ywa(Context paramContext, QQAppInterface paramQQAppInterface, yru paramyru, int paramInt, SlideDetectListView paramSlideDetectListView)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mApp = paramQQAppInterface;
    this.a = paramyru;
    this.unreadMsgNum = paramInt;
    this.g = paramSlideDetectListView;
  }
  
  private boolean b(structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      int k = paramStructMsg.msg.src_id.get();
      int m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
      localSystemMsgActionInfo.group_code.set(paramStructMsg.msg.group_code.get());
      localSystemMsgActionInfo.sig.set(ByteStringMicro.EMPTY);
      localSystemMsgActionInfo.type.set(15);
      this.mApp.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localSystemMsgActionInfo.get(), 3);
      bool = true;
    }
    return bool;
  }
  
  public void clearData()
  {
    if (this.fC != null) {
      this.fC.clear();
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.fC != null) {
      i = this.fC.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.fC == null) || (paramInt > this.fC.size()) || (paramInt < 0)) {
      return null;
    }
    return this.fC.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ywa.a locala;
    if (paramView == null)
    {
      paramView = this.mLayoutInflater.inflate(2131560104, paramViewGroup, false);
      locala = new ywa.a();
      locala.hC = ((LinearLayout)paramView.findViewById(2131374288));
      locala.uw = ((ImageView)paramView.findViewById(2131374278));
      locala.hD = ((LinearLayout)paramView.findViewById(2131374285));
      locala.uF = ((ImageView)paramView.findViewById(2131374292));
      locala.LW = ((TextView)paramView.findViewById(2131374283));
      locala.LX = ((TextView)paramView.findViewById(2131374289));
      locala.LY = ((TextView)paramView.findViewById(2131374291));
      locala.LZ = ((TextView)paramView.findViewById(2131374284));
      locala.ej = ((Button)paramView.findViewById(2131374287));
      locala.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131380367));
      ((Button)paramView.findViewById(2131380366)).setOnClickListener(this.eo);
      paramView.setTag(locala);
      locala.mPosition = paramInt;
      if (paramInt >= this.unreadMsgNum) {
        break label266;
      }
      ysa.C(paramView, true);
      ysa.C(locala.hC, true);
    }
    MessageRecord localMessageRecord;
    for (;;)
    {
      localMessageRecord = (MessageRecord)getItem(paramInt);
      if (localMessageRecord == null) {
        break label348;
      }
      if ((localMessageRecord instanceof MessageForSystemMsg)) {
        break label283;
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (ywa.a)paramView.getTag();
      break;
      label266:
      ysa.C(paramView, false);
      ysa.C(locala.hC, false);
    }
    label283:
    locala.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
    locala.uniseq = localMessageRecord.uniseq;
    if (localMessageRecord != null) {}
    for (int i = ((MessageForSystemMsg)localMessageRecord).getSystemMsg().msg_type.get();; i = 2)
    {
      if (i == 2) {
        this.a.a(locala, paramInt);
      }
      break;
      label348:
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void setData(List<MessageRecord> paramList)
  {
    HashSet localHashSet = new HashSet();
    if ((paramList == null) || (this.fC == null)) {}
    for (;;)
    {
      return;
      this.fC.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
          {
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
            this.fC.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public static class a
  {
    public long KO;
    public TextView LW;
    public TextView LX;
    public TextView LY;
    public TextView LZ;
    public long _id;
    public ShaderAnimLayout a;
    public structmsg.StructMsg a;
    public String aZL = "";
    public int bDQ;
    public Button ej;
    public LinearLayout hC;
    public LinearLayout hD;
    public int mPosition;
    public String nickname;
    public String senderUin;
    public ImageView uF;
    public long uniseq;
    public ImageView uw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywa
 * JD-Core Version:    0.7.0.1
 */