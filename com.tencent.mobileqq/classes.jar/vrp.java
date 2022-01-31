import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class vrp
  extends xvp
{
  public static final String KEY = "PlayerCommentSegment";
  private int jdField_a_of_type_Int;
  private vrd jdField_a_of_type_Vrd;
  private vrq jdField_a_of_type_Vrq = new vrq(this);
  private vrr jdField_a_of_type_Vrr = new vrr();
  private vrs jdField_a_of_type_Vrs = new vrs(this);
  private vrv jdField_a_of_type_Vrv;
  public wiq a;
  
  public vrp(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Vrd == null) || (this.jdField_a_of_type_Vrd.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null)) {
      return this.jdField_a_of_type_Wiq.a(b()).size();
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Wiq == null) || (paramInt > this.jdField_a_of_type_Wiq.a(b()).size()))
    {
      wxe.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramwtq.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wiq.a(b()).get(paramInt);
    if (localCommentEntry == null)
    {
      wxe.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramwtq.a();
    }
    paramViewGroup = (ImageView)paramwtq.a(2131362973);
    TextView localTextView1 = (TextView)paramwtq.a(2131371146);
    TextView localTextView2 = (TextView)paramwtq.a(2131364542);
    Object localObject1 = (LinearLayout)paramwtq.a(2131364536);
    TextView localTextView3 = (TextView)paramwtq.a(2131369760);
    ImageView localImageView = (ImageView)paramwtq.a(2131364553);
    ProgressBar localProgressBar = (ProgressBar)paramwtq.a(2131364578);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846005);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
      }
      return paramwtq.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Vrq.hashCode() + "bubble_style";
    Object localObject2 = utv.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((uwm)uwa.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bdhj.b();
      if (localQQUserUIItem != null) {
        break label616;
      }
      localObject1 = "";
      label383:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label626;
      }
      paramInt = 1;
      label393:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label631;
      }
      localObject2 = "V";
      label405:
      if (localQQUserUIItem != null) {
        break label638;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      label416:
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
        break label751;
      }
      paramViewGroup = new SpannableStringBuilder(vls.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        wix.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
      }
      localTextView1.setText(paramViewGroup);
      if (localCommentEntry.status != 2) {
        break label791;
      }
      localImageView.setVisibility(0);
      localProgressBar.setVisibility(8);
    }
    for (;;)
    {
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Vrr);
      localTextView2.setSpannableFactory(bamp.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = wix.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wiq.a, localCommentEntry, this.jdField_a_of_type_Vrq);
      localTextView2.setText((CharSequence)localObject2);
      if (localCommentEntry.isReply())
      {
        localQQUserUIItem = ((uwm)uwa.a(2)).c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          break label352;
        }
        utv.a().a((String)localObject1, (CharSequence)localObject2);
        break label352;
      }
      utv.a().a((String)localObject1, (CharSequence)localObject2);
      break label352;
      label616:
      localObject1 = localQQUserUIItem.getUserIconUrl();
      break label383;
      label626:
      paramInt = 0;
      break label393;
      label631:
      localObject2 = "";
      break label405;
      label638:
      if ((localQQUserUIItem.isVipButNoFriend()) || (localQQUserUIItem.isNotDovUser()))
      {
        xsm.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(bdbk.a(vls.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (ndd.a(localQQUserUIItem.headUrl))
      {
        xsm.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      break label416;
      label751:
      if (localQQUserUIItem.isVipButNoFriend())
      {
        paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.nickName);
        break label440;
      }
      paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.getDisplayName());
      break label440;
      label791:
      localImageView.setVisibility(8);
      if (localCommentEntry.status == 1) {
        localProgressBar.setVisibility(0);
      } else {
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  public CommentEntry a(int paramInt)
  {
    if ((this.jdField_a_of_type_Wiq == null) || (paramInt >= this.jdField_a_of_type_Wiq.a(this.jdField_a_of_type_Vrd.a()).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Wiq.a(this.jdField_a_of_type_Vrd.a()).get(paramInt);
  }
  
  public String a()
  {
    return "PlayerCommentSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561448, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Vrs);
    paramViewGroup.a(2131362973).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371146).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364543).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364543).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131369760).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131369760).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(vrd paramvrd, vrv paramvrv, int paramInt)
  {
    this.jdField_a_of_type_Vrd = paramvrd;
    this.jdField_a_of_type_Vrv = paramvrv;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(wiq paramwiq)
  {
    this.jdField_a_of_type_Wiq = paramwiq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrp
 * JD-Core Version:    0.7.0.1
 */