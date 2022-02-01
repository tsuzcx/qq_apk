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

public class wqg
  extends ysg
{
  public static final String KEY = "PlayerCommentSegment";
  private int jdField_a_of_type_Int;
  private wpu jdField_a_of_type_Wpu;
  private wqh jdField_a_of_type_Wqh = new wqh(this);
  private wqi jdField_a_of_type_Wqi = new wqi();
  private wqj jdField_a_of_type_Wqj = new wqj(this);
  private wqm jdField_a_of_type_Wqm;
  public xhh a;
  
  public wqg(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Wpu == null) || (this.jdField_a_of_type_Wpu.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null)) {
      return this.jdField_a_of_type_Xhh.a(b()).size();
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Xhh == null) || (paramInt > this.jdField_a_of_type_Xhh.a(b()).size()))
    {
      xvv.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramxsh.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Xhh.a(b()).get(paramInt);
    if (localCommentEntry == null)
    {
      xvv.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramxsh.a();
    }
    paramViewGroup = (ImageView)paramxsh.a(2131363126);
    TextView localTextView1 = (TextView)paramxsh.a(2131371777);
    TextView localTextView2 = (TextView)paramxsh.a(2131364835);
    Object localObject1 = (LinearLayout)paramxsh.a(2131364829);
    TextView localTextView3 = (TextView)paramxsh.a(2131370260);
    ImageView localImageView = (ImageView)paramxsh.a(2131364846);
    ProgressBar localProgressBar = (ProgressBar)paramxsh.a(2131364870);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130846369);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
      }
      return paramxsh.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Wqh.hashCode() + "bubble_style";
    Object localObject2 = vst.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((vvj)vux.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bfvo.b();
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
      paramViewGroup = new SpannableStringBuilder(wkp.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        xho.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
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
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Wqi);
      localTextView2.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = xho.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xhh.a, localCommentEntry, this.jdField_a_of_type_Wqh);
      localTextView2.setText((CharSequence)localObject2);
      if (localCommentEntry.isReply())
      {
        localQQUserUIItem = ((vvj)vux.a(2)).c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          break label352;
        }
        vst.a().a((String)localObject1, (CharSequence)localObject2);
        break label352;
      }
      vst.a().a((String)localObject1, (CharSequence)localObject2);
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
        paramViewGroup.setImageDrawable(FaceDrawable.getFaceDrawable(wkp.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
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
    if ((this.jdField_a_of_type_Xhh == null) || (paramInt >= this.jdField_a_of_type_Xhh.a(this.jdField_a_of_type_Wpu.a()).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Xhh.a(this.jdField_a_of_type_Wpu.a()).get(paramInt);
  }
  
  public String a()
  {
    return "PlayerCommentSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561603, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Wqj);
    paramViewGroup.a(2131363126).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131371777).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364836).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364836).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131370260).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370260).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(wpu paramwpu, wqm paramwqm, int paramInt)
  {
    this.jdField_a_of_type_Wpu = paramwpu;
    this.jdField_a_of_type_Wqm = paramwqm;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(xhh paramxhh)
  {
    this.jdField_a_of_type_Xhh = paramxhh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqg
 * JD-Core Version:    0.7.0.1
 */