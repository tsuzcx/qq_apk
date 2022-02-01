import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class uqf
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  Activity jdField_a_of_type_AndroidAppActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  public FaceDecoder a;
  protected List<uqe> a;
  private uqa jdField_a_of_type_Uqa;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public uqf(Activity paramActivity, QQAppInterface paramQQAppInterface, uqa paramuqa)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(11);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Uqa = paramuqa;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
      this.b = true;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<uqe> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 10) {}
      for (int i = 10;; i = paramList.size())
      {
        int j = 0;
        while (j < i)
        {
          a((uqe)paramList.get(j));
          j += 1;
        }
      }
      paramList = new uqe();
      paramList.a = -1L;
      a(paramList);
    }
  }
  
  public void a(uqe paramuqe)
  {
    if (paramuqe != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramuqe);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt > getCount()) || (paramInt < 0)) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131560438, null);
      paramView = new uqg(this, localView, this.jdField_a_of_type_Boolean);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((uqe)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      uqg localuqg = (uqg)paramView.getTag();
      localView = paramView;
      paramView = localuqg;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqf
 * JD-Core Version:    0.7.0.1
 */