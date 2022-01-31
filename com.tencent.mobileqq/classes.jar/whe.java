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

public class whe
  extends RecyclerView.ViewHolder
{
  private ahbe jdField_a_of_type_Ahbe;
  private ahde jdField_a_of_type_Ahde;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public rof a;
  private boolean jdField_a_of_type_Boolean;
  
  public whe(View paramView, ahbe paramahbe, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Ahbe = paramahbe;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Ahde = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131310137));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310142));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131310145));
  }
  
  private boolean a(rof paramrof1, rof paramrof2)
  {
    if ((paramrof1 != null) && (paramrof2 != null)) {
      if ((!paramrof1.jdField_a_of_type_JavaLangString.equals(paramrof2.jdField_a_of_type_JavaLangString)) || (paramrof1.b != paramrof2.b) || (paramrof1.jdField_a_of_type_Int != paramrof2.jdField_a_of_type_Int) || (!paramrof1.c.equals(paramrof2.c))) {
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
      paramImageView.setImageDrawable(this.jdField_a_of_type_Ahbe.a(1008, paramString));
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
  
  public void a(rof paramrof, int paramInt)
  {
    if ((paramrof == null) || (a(this.jdField_a_of_type_Rof, paramrof))) {
      return;
    }
    this.jdField_a_of_type_Rof = paramrof;
    this.itemView.setTag(this.jdField_a_of_type_Rof);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131310139, this.jdField_a_of_type_Rof);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131310137, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramrof.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramrof.jdField_a_of_type_JavaLangString);
    int j = paramrof.b;
    int i = paramrof.jdField_a_of_type_Int;
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
      beih.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      this.itemView.setOnClickListener(new whf(this, paramrof, paramInt));
      wye.a(paramrof.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramrof.c, paramrof.jdField_a_of_type_JavaLangCharSequence.toString() });
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
        k = 2130849057;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahde);
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
 * Qualified Name:     whe
 * JD-Core Version:    0.7.0.1
 */