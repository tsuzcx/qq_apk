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
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class xfb
  extends zgz
{
  public static final String KEY = "PlayerCommentSegment";
  private int jdField_a_of_type_Int;
  private xep jdField_a_of_type_Xep;
  private xfc jdField_a_of_type_Xfc = new xfc(this);
  private xfd jdField_a_of_type_Xfd = new xfd();
  private xfe jdField_a_of_type_Xfe = new xfe(this);
  private xfh jdField_a_of_type_Xfh;
  public xwc a;
  
  public xfb(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Xep == null) || (this.jdField_a_of_type_Xep.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null)) {
      return this.jdField_a_of_type_Xwc.a(b()).size();
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Xwc == null) || (paramInt > this.jdField_a_of_type_Xwc.a(b()).size()))
    {
      ykq.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramyhc.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Xwc.a(b()).get(paramInt);
    if (localCommentEntry == null)
    {
      ykq.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramyhc.a();
    }
    paramViewGroup = (ImageView)paramyhc.a(2131363145);
    TextView localTextView1 = (TextView)paramyhc.a(2131371966);
    TextView localTextView2 = (TextView)paramyhc.a(2131364922);
    Object localObject1 = (LinearLayout)paramyhc.a(2131364916);
    TextView localTextView3 = (TextView)paramyhc.a(2131370439);
    ImageView localImageView = (ImageView)paramyhc.a(2131364933);
    ProgressBar localProgressBar = (ProgressBar)paramyhc.a(2131364958);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846465);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
      }
      return paramyhc.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Xfc.hashCode() + "bubble_style";
    Object localObject2 = who.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((wke)wjs.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bheg.b();
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
      paramViewGroup = new SpannableStringBuilder(wzk.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        xwj.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
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
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Xfd);
      localTextView2.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = xwj.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xwc.a, localCommentEntry, this.jdField_a_of_type_Xfc);
      localTextView2.setText((CharSequence)localObject2);
      if (localCommentEntry.isReply())
      {
        localQQUserUIItem = ((wke)wjs.a(2)).c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          break label352;
        }
        who.a().a((String)localObject1, (CharSequence)localObject2);
        break label352;
      }
      who.a().a((String)localObject1, (CharSequence)localObject2);
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
        UIUtils.setCircleViewByURL(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(FaceDrawable.getFaceDrawable(wzk.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (HttpUtil.isValidUrl(localQQUserUIItem.headUrl))
      {
        UIUtils.setCircleViewByURL(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
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
    if ((this.jdField_a_of_type_Xwc == null) || (paramInt >= this.jdField_a_of_type_Xwc.a(this.jdField_a_of_type_Xep.a()).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Xwc.a(this.jdField_a_of_type_Xep.a()).get(paramInt);
  }
  
  public String a()
  {
    return "PlayerCommentSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561671, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Xfe);
    paramViewGroup.a(2131363145).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371966).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364923).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364923).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131370439).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370439).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(xep paramxep, xfh paramxfh, int paramInt)
  {
    this.jdField_a_of_type_Xep = paramxep;
    this.jdField_a_of_type_Xfh = paramxfh;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(xwc paramxwc)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfb
 * JD-Core Version:    0.7.0.1
 */