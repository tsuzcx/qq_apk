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

public class wwg
  extends RecyclerView.ViewHolder
{
  private ahnt jdField_a_of_type_Ahnt;
  private ahpt jdField_a_of_type_Ahpt;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public saw a;
  private boolean jdField_a_of_type_Boolean;
  
  public wwg(View paramView, ahnt paramahnt, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Ahnt = paramahnt;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Ahpt = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131375901));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375906));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131375909));
  }
  
  private boolean a(saw paramsaw1, saw paramsaw2)
  {
    if ((paramsaw1 != null) && (paramsaw2 != null)) {
      if ((!paramsaw1.jdField_a_of_type_JavaLangString.equals(paramsaw2.jdField_a_of_type_JavaLangString)) || (paramsaw1.b != paramsaw2.b) || (paramsaw1.jdField_a_of_type_Int != paramsaw2.jdField_a_of_type_Int) || (!paramsaw1.c.equals(paramsaw2.c))) {
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
      paramImageView.setImageDrawable(this.jdField_a_of_type_Ahnt.a(1008, paramString));
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
  
  public void a(saw paramsaw, int paramInt)
  {
    if ((paramsaw == null) || (a(this.jdField_a_of_type_Saw, paramsaw))) {
      return;
    }
    this.jdField_a_of_type_Saw = paramsaw;
    this.itemView.setTag(this.jdField_a_of_type_Saw);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131375903, this.jdField_a_of_type_Saw);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131375901, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramsaw.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramsaw.jdField_a_of_type_JavaLangString);
    int j = paramsaw.b;
    int i = paramsaw.jdField_a_of_type_Int;
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
      bfqb.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      this.itemView.setOnClickListener(new wwh(this, paramsaw, paramInt));
      xhe.a(paramsaw.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramsaw.c, paramsaw.jdField_a_of_type_JavaLangCharSequence.toString() });
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
        k = 2130849292;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahpt);
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
 * Qualified Name:     wwg
 * JD-Core Version:    0.7.0.1
 */