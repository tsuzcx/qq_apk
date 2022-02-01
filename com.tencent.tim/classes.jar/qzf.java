import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class qzf
  extends rsd<oidb_0x791.RedDotInfo>
  implements View.OnClickListener
{
  public static final String KEY = "MessageNotifySegment";
  private long Bz;
  private Integer M;
  private String azg;
  private int bgv;
  
  public qzf(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (this.bgv == 0)
    {
      paramqyd.get(2131379724).setVisibility(8);
      paramqyd.getItemView().setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      return paramqyd.getItemView();
    }
    paramInt = rpq.dip2px(paramqyd.getItemView().getContext(), 52.0F);
    paramqyd.get(2131379724).setVisibility(0);
    paramqyd.getItemView().setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
    paramqyd.getItemView().setVisibility(0);
    ImageView localImageView = (ImageView)paramqyd.get(2131368698);
    Drawable localDrawable = aqhu.at();
    QQStoryContext.a();
    if (QQStoryContext.a() == null) {
      localImageView.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      return paramqyd.getItemView();
      if ((localImageView.getTag() != null) && ((this.M == null) || (this.M.equals(localImageView.getTag())))) {
        return paramqyd.getItemView();
      }
      localImageView.setTag(this.M);
      localImageView.setImageDrawable(localDrawable);
      TextView localTextView = (TextView)paramqyd.get(2131365360);
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.bgv > 99) {}
      for (paramViewGroup = "99+";; paramViewGroup = Integer.valueOf(this.bgv))
      {
        localTextView.setText(paramViewGroup + acfp.m(2131708217));
        if (this.Bz > 0L) {
          break label272;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "uin <=0. fetch first message.");
        }
        n(localImageView);
        break;
      }
      label272:
      ThreadManager.post(new MessageNotifySegment.1(this, localImageView, localDrawable), 8, null, true);
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.context).inflate(2131561900, paramViewGroup, false);
    paramViewGroup.findViewById(2131379724).setOnClickListener(this);
    return new qyd(paramViewGroup);
  }
  
  protected void bqO()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    if (localQQAppInterface != null)
    {
      g(((jnv)localQQAppInterface.getManager(70)).a(52));
      return;
    }
    ram.e("Q.qqstory.home.MessageNotifySegment", "Get the QQAppInterface is null,we dont know the red point state");
  }
  
  public void g(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.get() == 52) && (paramRedDotInfo.bool_display_reddot.get()) && (paramRedDotInfo.uint32_number.get() > 0))
    {
      this.bgv = paramRedDotInfo.uint32_number.get();
      this.Bz = paramRedDotInfo.uint64_cmd_uin.get();
      this.M = Integer.valueOf(paramRedDotInfo.uint32_last_time.get());
      this.azg = paramRedDotInfo.str_face_url.get().toStringUtf8();
      return;
    }
    this.bgv = 0;
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public String getKey()
  {
    return "MessageNotifySegment";
  }
  
  public void n(ImageView paramImageView)
  {
    qqstory_710_message.ReqStoryMessageList localReqStoryMessageList = new qqstory_710_message.ReqStoryMessageList();
    localReqStoryMessageList.num.set(1);
    localReqStoryMessageList.start_time.set(0);
    localReqStoryMessageList.source.set(0);
    localReqStoryMessageList.version_ctrl.set(775);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch first message from gray, start=0");
    }
    QQStoryContext.a();
    jnm.a(QQStoryContext.a(), new qzf.a(this, paramImageView), localReqStoryMessageList.toByteArray(), ppf.fQ("StorySvc.get_710_message_list"));
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.context, StoryMessageListActivity.class);
    ((Intent)localObject).putExtra("qqstory_message_list_source", 0);
    ((Intent)localObject).putExtra("qqstory_jump_source", "2");
    this.context.startActivity((Intent)localObject);
    localObject = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
    if ((localObject != null) && (((QQUserUIItem)localObject).isVip))
    {
      i = 1;
      if (i == 0) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 2)
    {
      rar.a("play_video", "clk_grey", i, 0, new String[] { "", "", "", "" });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
    }
  }
  
  static class a
    extends jnm.b
  {
    WeakReference<qzf> da;
    WeakReference<ImageView> db;
    
    public a(qzf paramqzf, ImageView paramImageView)
    {
      this.da = new WeakReference(paramqzf);
      this.db = new WeakReference(paramImageView);
    }
    
    public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list result, code=" + paramInt);
      }
      qzf localqzf = (qzf)this.da.get();
      paramBundle = (ImageView)this.db.get();
      if ((localqzf == null) || (paramBundle == null)) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "weak reference null.");
        }
      }
      do
      {
        for (;;)
        {
          return null;
          if ((paramInt == 0) && (paramArrayOfByte != null)) {
            try
            {
              Object localObject = new qqstory_710_message.RspStoryMessageList();
              ((qqstory_710_message.RspStoryMessageList)localObject).mergeFrom(paramArrayOfByte);
              if ((((qqstory_710_message.RspStoryMessageList)localObject).errinfo.error_code.has()) && (((qqstory_710_message.RspStoryMessageList)localObject).errinfo.error_code.get() == 0) && (((qqstory_710_message.RspStoryMessageList)localObject).message_num.get() > 0) && (!((qqstory_710_message.RspStoryMessageList)localObject).message_list.get().isEmpty()))
              {
                paramArrayOfByte = ((qqstory_710_message.RspStoryMessageList)localObject).message_list.get().iterator();
                for (;;)
                {
                  if (paramArrayOfByte.hasNext())
                  {
                    localObject = new quo((qqstory_710_message.StoryMessage)paramArrayOfByte.next());
                    if (((quo)localObject).Zm)
                    {
                      paramArrayOfByte = ((quo)localObject).ayI;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "set bigV avatar from MessageData. unionId=" + paramArrayOfByte);
                      }
                      if (TextUtils.isEmpty(paramArrayOfByte)) {
                        break;
                      }
                      qem.a(paramBundle, qem.dw(paramArrayOfByte), true, (int)aqho.convertDpToPixel(qzf.b(localqzf), 33.0F));
                      return null;
                    }
                  }
                }
              }
            }
            catch (InvalidProtocolBufferMicroException paramArrayOfByte)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "parse RspStoryMessageList error", paramArrayOfByte);
              }
            }
          }
        }
        paramArrayOfByte = aqhu.at();
        QQStoryContext.a();
        paramArrayOfByte = aqdj.a(QQStoryContext.a(), 1, Long.toString(qzf.a(localqzf)), 3, paramArrayOfByte, paramArrayOfByte);
        if (paramArrayOfByte != null) {
          paramBundle.setImageDrawable(paramArrayOfByte);
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "fetch message list failed");
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzf
 * JD-Core Version:    0.7.0.1
 */