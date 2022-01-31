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
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class wgg
  extends xrg
{
  public static final String KEY = "DetailCommentSegment";
  private wdr jdField_a_of_type_Wdr;
  public weh a;
  private wgh jdField_a_of_type_Wgh = new wgh(1);
  private wgi jdField_a_of_type_Wgi = new wgi();
  private wgj jdField_a_of_type_Wgj = new wgj(this);
  private boolean b;
  
  public wgg(Context paramContext)
  {
    super(paramContext);
  }
  
  public void Z_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null)) {
      return this.jdField_a_of_type_Weh.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Weh == null) || (paramInt > this.jdField_a_of_type_Weh.a(this.b).size()))
    {
      wsv.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramwph.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Weh.a(this.b).get(paramInt);
    if (localCommentEntry == null)
    {
      wsv.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramwph.a();
    }
    paramViewGroup = (ImageView)paramwph.a(2131362973);
    TextView localTextView1 = (TextView)paramwph.a(2131371127);
    TextView localTextView2 = (TextView)paramwph.a(2131364540);
    Object localObject1 = (LinearLayout)paramwph.a(2131364534);
    TextView localTextView3 = (TextView)paramwph.a(2131369741);
    ImageView localImageView = (ImageView)paramwph.a(2131364551);
    ProgressBar localProgressBar = (ProgressBar)paramwph.a(2131364576);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130845932);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
      }
      return paramwph.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Wgh.hashCode() + "bubble_style";
    Object localObject2 = upm.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((usd)urr.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bdda.b();
      if (localQQUserUIItem != null) {
        break label565;
      }
      localObject1 = "";
      label383:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label575;
      }
      paramInt = 1;
      label393:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label580;
      }
      localObject2 = "V";
      label405:
      if (localQQUserUIItem != null) {
        break label587;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      label416:
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
        break label700;
      }
      paramViewGroup = new SpannableStringBuilder(vhj.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        weo.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
      }
      localTextView1.setText(paramViewGroup);
      if (localCommentEntry.status != 2) {
        break label740;
      }
      localImageView.setVisibility(0);
      localProgressBar.setVisibility(8);
    }
    for (;;)
    {
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Wgi);
      localTextView2.setSpannableFactory(baig.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = weo.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Weh.a, localCommentEntry, this.jdField_a_of_type_Wgh);
      localTextView2.setText((CharSequence)localObject2);
      upm.a().a((String)localObject1, (CharSequence)localObject2);
      break label352;
      label565:
      localObject1 = localQQUserUIItem.getUserIconUrl();
      break label383;
      label575:
      paramInt = 0;
      break label393;
      label580:
      localObject2 = "";
      break label405;
      label587:
      if ((localQQUserUIItem.isVipButNoFriend()) || (localQQUserUIItem.isNotDovUser()))
      {
        xod.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(bcxb.a(vhj.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (ndd.a(localQQUserUIItem.headUrl))
      {
        xod.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      break label416;
      label700:
      if (localQQUserUIItem.isVipButNoFriend())
      {
        paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.nickName);
        break label440;
      }
      paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.getDisplayName());
      break label440;
      label740:
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
    if ((this.jdField_a_of_type_Weh == null) || (paramInt >= this.jdField_a_of_type_Weh.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Weh.a(this.b).get(paramInt);
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561430, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Wgj);
    paramViewGroup.a(2131362973).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371127).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364541).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364541).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131369741).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131369741).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(wdr paramwdr)
  {
    this.jdField_a_of_type_Wdr = paramwdr;
    this.jdField_a_of_type_Wgh.a(paramwdr);
  }
  
  public void a(weh paramweh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Weh = paramweh;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgg
 * JD-Core Version:    0.7.0.1
 */