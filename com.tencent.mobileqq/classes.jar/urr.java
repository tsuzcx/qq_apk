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

public class urr
  extends wcr
{
  public static final String KEY = "DetailCommentSegment";
  private upc jdField_a_of_type_Upc;
  public ups a;
  private urs jdField_a_of_type_Urs = new urs(1);
  private urt jdField_a_of_type_Urt = new urt();
  private uru jdField_a_of_type_Uru = new uru(this);
  private boolean b;
  
  public urr(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null)) {
      return this.jdField_a_of_type_Ups.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Ups == null) || (paramInt > this.jdField_a_of_type_Ups.a(this.b).size()))
    {
      veg.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramvas.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ups.a(this.b).get(paramInt);
    if (localCommentEntry == null)
    {
      veg.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramvas.a();
    }
    paramViewGroup = (ImageView)paramvas.a(2131362939);
    TextView localTextView1 = (TextView)paramvas.a(2131370816);
    TextView localTextView2 = (TextView)paramvas.a(2131364469);
    Object localObject1 = (LinearLayout)paramvas.a(2131364463);
    TextView localTextView3 = (TextView)paramvas.a(2131369480);
    ImageView localImageView = (ImageView)paramvas.a(2131364480);
    ProgressBar localProgressBar = (ProgressBar)paramvas.a(2131364505);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130845547);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      }
      return paramvas.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Urs.hashCode() + "bubble_style";
    Object localObject2 = tax.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((tdo)tdc.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bbdr.b();
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
      paramViewGroup = new SpannableStringBuilder(tsu.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        upz.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
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
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Urt);
      localTextView2.setSpannableFactory(ayki.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = upz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ups.a, localCommentEntry, this.jdField_a_of_type_Urs);
      localTextView2.setText((CharSequence)localObject2);
      tax.a().a((String)localObject1, (CharSequence)localObject2);
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
        vzo.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(baxt.a(tsu.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (nam.a(localQQUserUIItem.headUrl))
      {
        vzo.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
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
    if ((this.jdField_a_of_type_Ups == null) || (paramInt >= this.jdField_a_of_type_Ups.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Ups.a(this.b).get(paramInt);
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561241, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Uru);
    paramViewGroup.a(2131362939).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131370816).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364470).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131364470).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131369480).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131369480).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(upc paramupc)
  {
    this.jdField_a_of_type_Upc = paramupc;
    this.jdField_a_of_type_Urs.a(paramupc);
  }
  
  public void a(ups paramups, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ups = paramups;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urr
 * JD-Core Version:    0.7.0.1
 */