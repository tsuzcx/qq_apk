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

public class ykw
  extends RecyclerView.ViewHolder
{
  private ajfa jdField_a_of_type_Ajfa;
  private ajha jdField_a_of_type_Ajha;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public ssj a;
  private boolean jdField_a_of_type_Boolean;
  
  public ykw(View paramView, ajfa paramajfa, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Ajfa = paramajfa;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Ajha = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131376402));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376407));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131376410));
  }
  
  private boolean a(ssj paramssj1, ssj paramssj2)
  {
    if ((paramssj1 != null) && (paramssj2 != null)) {
      if ((!paramssj1.jdField_a_of_type_JavaLangString.equals(paramssj2.jdField_a_of_type_JavaLangString)) || (paramssj1.b != paramssj2.b) || (paramssj1.jdField_a_of_type_Int != paramssj2.jdField_a_of_type_Int) || (!paramssj1.c.equals(paramssj2.c))) {
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
      paramImageView.setImageDrawable(this.jdField_a_of_type_Ajfa.a(1008, paramString));
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
  
  public void a(ssj paramssj, int paramInt)
  {
    if ((paramssj == null) || (a(this.jdField_a_of_type_Ssj, paramssj))) {
      return;
    }
    this.jdField_a_of_type_Ssj = paramssj;
    this.itemView.setTag(this.jdField_a_of_type_Ssj);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131376404, this.jdField_a_of_type_Ssj);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131376402, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramssj.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramssj.jdField_a_of_type_JavaLangString);
    int j = paramssj.b;
    int i = paramssj.jdField_a_of_type_Int;
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
      bhro.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      this.itemView.setOnClickListener(new ykx(this, paramssj, paramInt));
      yvu.a(paramssj.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramssj.c, paramssj.jdField_a_of_type_JavaLangCharSequence.toString() });
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
        k = 2130849732;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajha);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykw
 * JD-Core Version:    0.7.0.1
 */