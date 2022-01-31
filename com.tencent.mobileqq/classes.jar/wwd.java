import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wwd
  extends RecyclerView.ViewHolder
{
  private ahnr jdField_a_of_type_Ahnr;
  private ahpr jdField_a_of_type_Ahpr;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public sat a;
  private boolean jdField_a_of_type_Boolean;
  
  public wwd(View paramView, ahnr paramahnr, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Ahnr = paramahnr;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Ahpr = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131375903));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375908));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131375911));
  }
  
  private boolean a(sat paramsat1, sat paramsat2)
  {
    if ((paramsat1 != null) && (paramsat2 != null)) {
      if ((!paramsat1.jdField_a_of_type_JavaLangString.equals(paramsat2.jdField_a_of_type_JavaLangString)) || (paramsat1.b != paramsat2.b) || (paramsat1.jdField_a_of_type_Int != paramsat2.jdField_a_of_type_Int) || (!paramsat1.c.equals(paramsat2.c))) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 4, "isSameServiceData:" + bool);
      return false;
    }
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.jdField_a_of_type_Ahnr.a(1008, paramString));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramImageView.setColorFilter(1711276032);
      }
      return;
      paramImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(sat paramsat, int paramInt)
  {
    if ((paramsat == null) || (a(this.jdField_a_of_type_Sat, paramsat))) {
      return;
    }
    this.jdField_a_of_type_Sat = paramsat;
    this.itemView.setTag(this.jdField_a_of_type_Sat);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131375905, this.jdField_a_of_type_Sat);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131375903, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramsat.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramsat.jdField_a_of_type_JavaLangString);
    int j = paramsat.b;
    int i = paramsat.jdField_a_of_type_Int;
    int k;
    if (j > 0) {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
        j = 0;
        k = 0;
        i = 0;
      }
    }
    for (;;)
    {
      bfqs.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      this.itemView.setOnClickListener(new wwe(this, paramsat, paramInt));
      xhb.a(paramsat.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramsat.c, paramsat.jdField_a_of_type_JavaLangCharSequence.toString() });
      return;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
        j = 0;
        k = 0;
        i = 1;
      }
      else
      {
        i = 3;
        k = 2130849301;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahpr);
        continue;
        j = 0;
        k = 0;
        i = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwd
 * JD-Core Version:    0.7.0.1
 */