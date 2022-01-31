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

public class tyo
  extends wco
{
  public static final String KEY = "PlayerCommentSegment";
  private int jdField_a_of_type_Int;
  private tyc jdField_a_of_type_Tyc;
  private typ jdField_a_of_type_Typ = new typ(this);
  private tyq jdField_a_of_type_Tyq = new tyq();
  private tyr jdField_a_of_type_Tyr = new tyr(this);
  private tyu jdField_a_of_type_Tyu;
  public upp a;
  
  public tyo(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Tyc == null) || (this.jdField_a_of_type_Tyc.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null)) {
      return this.jdField_a_of_type_Upp.a(b()).size();
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Upp == null) || (paramInt > this.jdField_a_of_type_Upp.a(b()).size()))
    {
      ved.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramvap.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Upp.a(b()).get(paramInt);
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
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Typ.hashCode() + "bubble_style";
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
        break label791;
      }
      localImageView.setVisibility(0);
      localProgressBar.setVisibility(8);
    }
    for (;;)
    {
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Tyq);
      localTextView2.setSpannableFactory(aykk.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = upw.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Upp.a, localCommentEntry, this.jdField_a_of_type_Typ);
      localTextView2.setText((CharSequence)localObject2);
      if (localCommentEntry.isReply())
      {
        localQQUserUIItem = ((tdl)tcz.a(2)).c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          break label352;
        }
        tau.a().a((String)localObject1, (CharSequence)localObject2);
        break label352;
      }
      tau.a().a((String)localObject1, (CharSequence)localObject2);
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
    if ((this.jdField_a_of_type_Upp == null) || (paramInt >= this.jdField_a_of_type_Upp.a(this.jdField_a_of_type_Tyc.a()).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Upp.a(this.jdField_a_of_type_Tyc.a()).get(paramInt);
  }
  
  public String a()
  {
    return "PlayerCommentSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561240, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Tyr);
    paramViewGroup.a(2131362938).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370816).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364469).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364469).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131369479).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131369479).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(tyc paramtyc, tyu paramtyu, int paramInt)
  {
    this.jdField_a_of_type_Tyc = paramtyc;
    this.jdField_a_of_type_Tyu = paramtyu;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(upp paramupp)
  {
    this.jdField_a_of_type_Upp = paramupp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyo
 * JD-Core Version:    0.7.0.1
 */