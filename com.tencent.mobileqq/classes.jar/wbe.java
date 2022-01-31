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

public class wbe
  extends RecyclerView.ViewHolder
{
  public Context a;
  public ImageView a;
  public TextView a;
  public way a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  public TextView e;
  
  public wbe(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363968));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363985));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364008));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364001));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364006));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363986));
    this.e = ((TextView)paramView.findViewById(2131364002));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373688));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373275));
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
    int i = (xee.a(this.jdField_a_of_type_AndroidContentContext) - xod.a(this.jdField_a_of_type_AndroidContentContext, 25.0F)) / 2;
    int j = (int)(i * 1.61D);
    this.itemView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = j;
    Object localObject;
    if (paramHotSortVideoEntry.coverURL == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846089));
      localObject = paramHotSortVideoEntry.storyId;
      this.itemView.setOnClickListener(new wbf(this, (String)localObject));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = ((usd)urr.a(2)).c(paramHotSortVideoEntry.unionId);
      if (localObject != null) {
        break label333;
      }
      if (!"NullImage".equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag("NullImage");
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(bdda.a());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ume.a(2131700054));
      label217:
      if ((paramHotSortVideoEntry.likeCount != 0) || (paramHotSortVideoEntry.viewCount != 0)) {
        break label516;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      wta.a("share_story", "exp_video_card", 0, 0, new String[] { paramHotSortVideoEntry.groupId, paramHotSortVideoEntry.storyId });
      return;
      localObject = xoa.c(paramHotSortVideoEntry.coverURL);
      if (((String)localObject).equals(this.jdField_a_of_type_AndroidWidgetImageView.getTag())) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject);
      xod.a(this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, i, j, i / 30, xod.b, "QQStoryMemory");
      break;
      label333:
      if (!((QQUserUIItem)localObject).headUrl.equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(((QQUserUIItem)localObject).headUrl);
        wbb.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, ((QQUserUIItem)localObject).headUrl);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject).getDisplayName());
      if (((QQUserUIItem)localObject).isVipButNoFriend())
      {
        if (umj.a())
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          j = xod.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(i - j);
          break label217;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        vhj.a(this.jdField_d_of_type_AndroidWidgetImageView, (QQUserUIItem)localObject);
        localObject = vhj.b((QQUserUIItem)localObject);
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
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846362);
      ((Drawable)localObject).setBounds(0, 0, xod.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(xod.a(paramHotSortVideoEntry.viewCount));
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845956);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      this.e.setText(xod.a(paramHotSortVideoEntry.likeCount));
      this.e.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.e.setVisibility(0);
    }
  }
  
  public void a(way paramway)
  {
    this.jdField_a_of_type_Way = paramway;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbe
 * JD-Core Version:    0.7.0.1
 */