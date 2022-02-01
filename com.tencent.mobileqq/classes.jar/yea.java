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

public class yea
  extends zpa
{
  public static final String KEY = "DetailCommentSegment";
  private ybl jdField_a_of_type_Ybl;
  public ycb a;
  private yeb jdField_a_of_type_Yeb = new yeb(1);
  private yec jdField_a_of_type_Yec = new yec();
  private yed jdField_a_of_type_Yed = new yed(this);
  private boolean b;
  
  public yea(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null)) {
      return this.jdField_a_of_type_Ycb.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Ycb == null) || (paramInt > this.jdField_a_of_type_Ycb.a(this.b).size()))
    {
      yqp.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramynb.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ycb.a(this.b).get(paramInt);
    if (localCommentEntry == null)
    {
      yqp.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramynb.a();
    }
    paramViewGroup = (ImageView)paramynb.a(2131363088);
    TextView localTextView1 = (TextView)paramynb.a(2131371705);
    TextView localTextView2 = (TextView)paramynb.a(2131364758);
    Object localObject1 = (LinearLayout)paramynb.a(2131364751);
    TextView localTextView3 = (TextView)paramynb.a(2131370191);
    ImageView localImageView = (ImageView)paramynb.a(2131364769);
    ProgressBar localProgressBar = (ProgressBar)paramynb.a(2131364793);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846444);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
      }
      return paramynb.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Yeb.hashCode() + "bubble_style";
    Object localObject2 = wnh.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((wpy)wpm.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bgmo.b();
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
      paramViewGroup = new SpannableStringBuilder(xfe.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        yci.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
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
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Yec);
      localTextView2.setSpannableFactory(bdnt.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = yci.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ycb.a, localCommentEntry, this.jdField_a_of_type_Yeb);
      localTextView2.setText((CharSequence)localObject2);
      wnh.a().a((String)localObject1, (CharSequence)localObject2);
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
        zlx.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(aoch.a(xfe.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (nlw.a(localQQUserUIItem.headUrl))
      {
        zlx.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
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
    if ((this.jdField_a_of_type_Ycb == null) || (paramInt >= this.jdField_a_of_type_Ycb.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Ycb.a(this.b).get(paramInt);
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561684, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Yed);
    paramViewGroup.a(2131363088).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371705).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364759).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364759).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131370191).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370191).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(ybl paramybl)
  {
    this.jdField_a_of_type_Ybl = paramybl;
    this.jdField_a_of_type_Yeb.a(paramybl);
  }
  
  public void a(ycb paramycb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yea
 * JD-Core Version:    0.7.0.1
 */