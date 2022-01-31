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

public class uro
  extends wco
{
  public static final String KEY = "DetailCommentSegment";
  private uoz jdField_a_of_type_Uoz;
  public upp a;
  private urp jdField_a_of_type_Urp = new urp(1);
  private urq jdField_a_of_type_Urq = new urq();
  private urr jdField_a_of_type_Urr = new urr(this);
  private boolean b;
  
  public uro(Context paramContext)
  {
    super(paramContext);
  }
  
  public void R_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null)) {
      return this.jdField_a_of_type_Upp.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Upp == null) || (paramInt > this.jdField_a_of_type_Upp.a(this.b).size()))
    {
      ved.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramvap.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Upp.a(this.b).get(paramInt);
    if (localCommentEntry == null)
    {
      ved.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramvap.a();
    }
    paramViewGroup = (ImageView)paramvap.a(2131362938);
    TextView localTextView1 = (TextView)paramvap.a(2131370816);
    TextView localTextView2 = (TextView)paramvap.a(2131364468);
    Object localObject1 = (LinearLayout)paramvap.a(2131364462);
    TextView localTextView3 = (TextView)paramvap.a(2131369479);
    ImageView localImageView = (ImageView)paramvap.a(2131364479);
    ProgressBar localProgressBar = (ProgressBar)paramvap.a(2131364504);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130845553);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      }
      return paramvap.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Urp.hashCode() + "bubble_style";
    Object localObject2 = tau.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((tdl)tcz.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bbef.b();
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
      paramViewGroup = new SpannableStringBuilder(tsr.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        upw.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
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
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Urq);
      localTextView2.setSpannableFactory(aykk.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = upw.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Upp.a, localCommentEntry, this.jdField_a_of_type_Urp);
      localTextView2.setText((CharSequence)localObject2);
      tau.a().a((String)localObject1, (CharSequence)localObject2);
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
        vzl.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(bayh.a(tsr.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (naj.a(localQQUserUIItem.headUrl))
      {
        vzl.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
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
    if ((this.jdField_a_of_type_Upp == null) || (paramInt >= this.jdField_a_of_type_Upp.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Upp.a(this.b).get(paramInt);
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561240, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Urr);
    paramViewGroup.a(2131362938).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370816).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364469).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364469).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131369479).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131369479).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_Uoz = paramuoz;
    this.jdField_a_of_type_Urp.a(paramuoz);
  }
  
  public void a(upp paramupp, boolean paramBoolean)
  {
    this.jdField_a_of_type_Upp = paramupp;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uro
 * JD-Core Version:    0.7.0.1
 */