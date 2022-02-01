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

public class yhv
  extends zsv
{
  public static final String KEY = "DetailCommentSegment";
  private yfg jdField_a_of_type_Yfg;
  public yfw a;
  private yhw jdField_a_of_type_Yhw = new yhw(1);
  private yhx jdField_a_of_type_Yhx = new yhx();
  private yhy jdField_a_of_type_Yhy = new yhy(this);
  private boolean b;
  
  public yhv(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null)) {
      return this.jdField_a_of_type_Yfw.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Yfw == null) || (paramInt > this.jdField_a_of_type_Yfw.a(this.b).size()))
    {
      yuk.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramyqw.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Yfw.a(this.b).get(paramInt);
    if (localCommentEntry == null)
    {
      yuk.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramyqw.a();
    }
    paramViewGroup = (ImageView)paramyqw.a(2131363109);
    TextView localTextView1 = (TextView)paramyqw.a(2131371813);
    TextView localTextView2 = (TextView)paramyqw.a(2131364805);
    Object localObject1 = (LinearLayout)paramyqw.a(2131364798);
    TextView localTextView3 = (TextView)paramyqw.a(2131370292);
    ImageView localImageView = (ImageView)paramyqw.a(2131364816);
    ProgressBar localProgressBar = (ProgressBar)paramyqw.a(2131364840);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846461);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
      }
      return paramyqw.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Yhw.hashCode() + "bubble_style";
    Object localObject2 = wrc.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((wtt)wth.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bhmq.b();
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
      paramViewGroup = new SpannableStringBuilder(xiz.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        ygd.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
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
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Yhx);
      localTextView2.setSpannableFactory(begp.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = ygd.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Yfw.a, localCommentEntry, this.jdField_a_of_type_Yhw);
      localTextView2.setText((CharSequence)localObject2);
      wrc.a().a((String)localObject1, (CharSequence)localObject2);
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
        zps.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(aoot.a(xiz.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (nnr.a(localQQUserUIItem.headUrl))
      {
        zps.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
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
    if ((this.jdField_a_of_type_Yfw == null) || (paramInt >= this.jdField_a_of_type_Yfw.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Yfw.a(this.b).get(paramInt);
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561725, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Yhy);
    paramViewGroup.a(2131363109).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371813).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364806).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364806).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131370292).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370292).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(yfg paramyfg)
  {
    this.jdField_a_of_type_Yfg = paramyfg;
    this.jdField_a_of_type_Yhw.a(paramyfg);
  }
  
  public void a(yfw paramyfw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yfw = paramyfw;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhv
 * JD-Core Version:    0.7.0.1
 */