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

public class yct
  extends RecyclerView.ViewHolder
{
  public Context a;
  public ImageView a;
  public TextView a;
  public ycn a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  public TextView e;
  
  public yct(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364214));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364232));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364256));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364248));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364254));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364233));
    this.e = ((TextView)paramView.findViewById(2131364249));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374579));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374166));
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
    int i = (zft.a(this.jdField_a_of_type_AndroidContentContext) - zps.a(this.jdField_a_of_type_AndroidContentContext, 25.0F)) / 2;
    int j = (int)(i * 1.61D);
    this.itemView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = j;
    Object localObject;
    if (paramHotSortVideoEntry.coverURL == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846618));
      localObject = paramHotSortVideoEntry.storyId;
      this.itemView.setOnClickListener(new ycu(this, (String)localObject));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = ((wtt)wth.a(2)).c(paramHotSortVideoEntry.unionId);
      if (localObject != null) {
        break label333;
      }
      if (!"NullImage".equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag("NullImage");
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(bhmq.a());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(wnu.a(2131698599));
      label217:
      if ((paramHotSortVideoEntry.likeCount != 0) || (paramHotSortVideoEntry.viewCount != 0)) {
        break label516;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      yup.a("share_story", "exp_video_card", 0, 0, new String[] { paramHotSortVideoEntry.groupId, paramHotSortVideoEntry.storyId });
      return;
      localObject = zpp.c(paramHotSortVideoEntry.coverURL);
      if (((String)localObject).equals(this.jdField_a_of_type_AndroidWidgetImageView.getTag())) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject);
      zps.a(this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, i, j, i / 30, zps.b, "QQStoryMemory");
      break;
      label333:
      if (!((QQUserUIItem)localObject).headUrl.equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(((QQUserUIItem)localObject).headUrl);
        ycq.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, ((QQUserUIItem)localObject).headUrl);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject).getDisplayName());
      if (((QQUserUIItem)localObject).isVipButNoFriend())
      {
        if (wnz.a())
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          j = zps.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(i - j);
          break label217;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        xiz.a(this.jdField_d_of_type_AndroidWidgetImageView, (QQUserUIItem)localObject);
        localObject = xiz.b((QQUserUIItem)localObject);
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
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846890);
      ((Drawable)localObject).setBounds(0, 0, zps.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), zps.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(zps.a(paramHotSortVideoEntry.viewCount));
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846485);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      this.e.setText(zps.a(paramHotSortVideoEntry.likeCount));
      this.e.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.e.setVisibility(0);
    }
  }
  
  public void a(ycn paramycn)
  {
    this.jdField_a_of_type_Ycn = paramycn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yct
 * JD-Core Version:    0.7.0.1
 */