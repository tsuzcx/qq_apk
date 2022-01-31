import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class tpk
{
  private static int jdField_a_of_type_Int;
  private static Context jdField_a_of_type_AndroidContentContext;
  static ArrayList<tpu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  static boolean jdField_a_of_type_Boolean;
  private static int b;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected bhuw a;
  
  public tpk(Activity paramActivity, ArrayList<tpu> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bhuw = new tpl(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    jdField_a_of_type_Int = paramInt1;
    b = paramInt2;
    jdField_a_of_type_Boolean = paramBoolean;
    jdField_a_of_type_JavaUtilArrayList = a(paramArrayList);
  }
  
  static int a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int i = jdField_a_of_type_JavaUtilArrayList.size();
    int j = (jdField_a_of_type_Int - aepi.a(110.0F, jdField_a_of_type_AndroidContentContext.getResources())) / 3;
    if (i % 2 == 0) {
      return i / 2 * j;
    }
    return (i + 1) / 2 * j;
  }
  
  private ArrayList<tpu> a(ArrayList<tpu> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramArrayList.size() <= 6)
    {
      localArrayList.addAll(paramArrayList);
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= 6) {
        break;
      }
      localArrayList.add(paramArrayList.get(i));
      i += 1;
    }
  }
  
  @TargetApi(9)
  private void a(RelativeLayout paramRelativeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "buildView!");
    }
    int i = aepi.a(2.0F, jdField_a_of_type_AndroidContentContext.getResources());
    int j = (b - i) / 2;
    paramRelativeLayout = (GridView)paramRelativeLayout.findViewById(2131375469);
    paramRelativeLayout.setColumnWidth(j);
    paramRelativeLayout.setStretchMode(0);
    paramRelativeLayout.setHorizontalSpacing(i);
    paramRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, a()));
    paramRelativeLayout.setNumColumns(2);
    paramRelativeLayout.setOnItemClickListener(this.jdField_a_of_type_Bhuw);
    if (Build.VERSION.SDK_INT >= 9) {
      paramRelativeLayout.setOverScrollMode(2);
    }
    paramRelativeLayout.setAdapter(new tpm(this));
  }
  
  public View a(Activity paramActivity, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramView = (RelativeLayout)paramView;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof tpo)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView reuse!");
        }
        return paramView;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView new create!");
    }
    paramActivity = (RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131559460, paramViewGroup, false);
    paramView = paramActivity.getLayoutParams();
    paramView.height = jdField_a_of_type_Int;
    paramActivity.setLayoutParams(paramView);
    paramView = new tpo();
    paramView.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramActivity.findViewById(2131375469));
    paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramActivity.findViewById(2131370100));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131375455));
    paramActivity.setTag(paramView);
    if ((jdField_a_of_type_JavaUtilArrayList == null) && (jdField_a_of_type_Boolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView getRecommendInfo error");
      }
      paramView.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup = paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.getLayoutParams();
      int i = aepi.a(66.0F, jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.height = (jdField_a_of_type_Int - i);
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setLayoutParams(paramViewGroup);
    }
    for (;;)
    {
      return paramActivity;
      paramViewGroup = paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.getLayoutParams();
      paramViewGroup.height = a();
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setLayoutParams(paramViewGroup);
      paramView.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(paramActivity);
    }
  }
  
  public void a(ArrayList<tpu> paramArrayList)
  {
    jdField_a_of_type_JavaUtilArrayList = a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tpk
 * JD-Core Version:    0.7.0.1
 */