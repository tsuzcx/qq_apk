import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.UIUtils;

public class xsz
  extends RecyclerView.ViewHolder
{
  public Context a;
  public ImageView a;
  public TextView a;
  public xst a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  public TextView e;
  
  public xsz(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364310));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364329));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364353));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364345));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364351));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364330));
    this.e = ((TextView)paramView.findViewById(2131364346));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374585));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374138));
  }
  
  public void a()
  {
    this.itemView.setVisibility(8);
  }
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    if (paramHotSortVideoEntry == null)
    {
      this.itemView.setVisibility(8);
      return;
    }
    this.itemView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    int i = (DisplayUtil.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 25.0F)) / 2;
    int j = (int)(i * 1.61D);
    this.itemView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = j;
    Object localObject;
    if (paramHotSortVideoEntry.coverURL == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846622));
      localObject = paramHotSortVideoEntry.storyId;
      this.itemView.setOnClickListener(new xta(this, (String)localObject));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = ((wke)wjs.a(2)).c(paramHotSortVideoEntry.unionId);
      if (localObject != null) {
        break label333;
      }
      if (!"NullImage".equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag("NullImage");
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(bheg.a());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(weg.a(2131699185));
      label217:
      if ((paramHotSortVideoEntry.likeCount != 0) || (paramHotSortVideoEntry.viewCount != 0)) {
        break label516;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      ykv.a("share_story", "exp_video_card", 0, 0, new String[] { paramHotSortVideoEntry.groupId, paramHotSortVideoEntry.storyId });
      return;
      localObject = zfe.c(paramHotSortVideoEntry.coverURL);
      if (((String)localObject).equals(this.jdField_a_of_type_AndroidWidgetImageView.getTag())) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject);
      UIUtils.setRoundCornerViewByURL(this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, i, j, i / 30, UIUtils.roundDefaultIcon, "QQStoryMemory");
      break;
      label333:
      if (!((QQUserUIItem)localObject).headUrl.equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(((QQUserUIItem)localObject).headUrl);
        xsw.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, ((QQUserUIItem)localObject).headUrl);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject).getDisplayName());
      if (((QQUserUIItem)localObject).isVipButNoFriend())
      {
        if (wel.a())
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 72.0F);
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(i - j);
          break label217;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        wzk.a(this.jdField_d_of_type_AndroidWidgetImageView, (QQUserUIItem)localObject);
        localObject = wzk.b((QQUserUIItem)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label217;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setTag(localObject);
        break label217;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break label217;
      label516:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846894);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(UIUtils.formatCount(paramHotSortVideoEntry.viewCount));
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846489);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      this.e.setText(UIUtils.formatCount(paramHotSortVideoEntry.likeCount));
      this.e.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.e.setVisibility(0);
    }
  }
  
  public void a(xst paramxst)
  {
    this.jdField_a_of_type_Xst = paramxst;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsz
 * JD-Core Version:    0.7.0.1
 */