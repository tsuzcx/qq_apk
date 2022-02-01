import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class yiz
  extends zgz<oidb_0x791.RedDotInfo>
  implements View.OnClickListener
{
  public static final String KEY = "MessageNotifySegment";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  
  public yiz(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      paramyhc.a(2131378963).setVisibility(8);
      paramyhc.a().setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      return paramyhc.a();
    }
    paramInt = UIUtils.dip2px(paramyhc.a().getContext(), 52.0F);
    paramyhc.a(2131378963).setVisibility(0);
    paramyhc.a().setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
    paramyhc.a().setVisibility(0);
    ImageView localImageView = (ImageView)paramyhc.a(2131368381);
    Drawable localDrawable = bheg.b();
    QQStoryContext.a();
    if (QQStoryContext.a() == null) {
      localImageView.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      return paramyhc.a();
      if ((localImageView.getTag() != null) && ((this.jdField_a_of_type_JavaLangInteger == null) || (this.jdField_a_of_type_JavaLangInteger.equals(localImageView.getTag())))) {
        return paramyhc.a();
      }
      localImageView.setTag(this.jdField_a_of_type_JavaLangInteger);
      localImageView.setImageDrawable(localDrawable);
      TextView localTextView = (TextView)paramyhc.a(2131365157);
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_Int > 99) {}
      for (paramViewGroup = "99+";; paramViewGroup = Integer.valueOf(this.jdField_a_of_type_Int))
      {
        localTextView.setText(paramViewGroup + anvx.a(2131706113));
        if (this.jdField_a_of_type_Long > 0L) {
          break label272;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.MessageNotifySegment", 2, "uin <=0. fetch first message.");
        }
        a(localImageView);
        break;
      }
      label272:
      ThreadManager.post(new MessageNotifySegment.1(this, localImageView, localDrawable), 8, null, true);
    }
  }
  
  public String a()
  {
    return "MessageNotifySegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561729, paramViewGroup, false);
    paramViewGroup.findViewById(2131378963).setOnClickListener(this);
    return new yhc(paramViewGroup);
  }
  
  public void a(ImageView paramImageView)
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
    ntb.a(QQStoryContext.a(), new yja(this, paramImageView), localReqStoryMessageList.toByteArray(), weg.a("StorySvc.get_710_message_list"));
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.get() == 52) && (paramRedDotInfo.bool_display_reddot.get()) && (paramRedDotInfo.uint32_number.get() > 0))
    {
      this.jdField_a_of_type_Int = paramRedDotInfo.uint32_number.get();
      this.jdField_a_of_type_Long = paramRedDotInfo.uint64_cmd_uin.get();
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramRedDotInfo.uint32_last_time.get());
      this.jdField_a_of_type_JavaLangString = paramRedDotInfo.str_face_url.get().toStringUtf8();
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void c()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    if (localQQAppInterface != null)
    {
      a(((ntq)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(52));
      return;
    }
    ykq.e("Q.qqstory.home.MessageNotifySegment", "Get the QQAppInterface is null,we dont know the red point state");
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, StoryMessageListActivity.class);
    ((Intent)localObject).putExtra("qqstory_message_list_source", 0);
    ((Intent)localObject).putExtra("qqstory_jump_source", "2");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    localObject = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
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
      ykv.a("play_video", "clk_grey", i, 0, new String[] { "", "", "", "" });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiz
 * JD-Core Version:    0.7.0.1
 */