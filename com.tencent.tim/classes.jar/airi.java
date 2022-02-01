import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.HeadSetViewModule.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class airi
  implements View.OnClickListener
{
  private TextView Up;
  private aiun jdField_a_of_type_Aiun;
  private PublicFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity;
  private LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  
  public airi(Context paramContext)
  {
    if ((paramContext instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity = ((PublicFragmentActivity)paramContext);
    }
    initData();
    initView();
  }
  
  private void duf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, new Object[] { "onClickMinimizeShare: invoked. ", " textSharingCount: ", this.Up });
    }
    if (aivd.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.finish();
    }
    anot.a(null, "CliOper", "", "", "0X800A76F", "0X800A76F", 0, 0, "", "0", "0", "");
  }
  
  private void dug()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetViewModule", 2, "onClickCancelShare: invoked. ");
    }
    ausj localausj = ausj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity);
    localausj.addButton(2131693130, 3);
    localausj.setMainTitle(2131696265);
    localausj.addCancelButton(2131721058);
    localausj.a(new airj(this, localausj));
    localausj.show();
    anot.a(null, "CliOper", "", "", "0X800A76D", "0X800A76D", 0, 0, "", "0", "0", "");
  }
  
  private void ey(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramArrayList.iterator();
      String str2;
      for (String str1 = ""; localIterator.hasNext(); str1 = str1 + ", " + str2) {
        str2 = (String)localIterator.next();
      }
      QLog.d("HeadSetViewModule", 2, new Object[] { "refreshHeadSet: invoked. ", " uins: ", str1, " headAdapter.count: ", Integer.valueOf(this.jdField_a_of_type_Aiun.getCount()) });
    }
    if (this.jdField_a_of_type_Aiun == null) {
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      QLog.e("HeadSetViewModule", 1, "refreshHeadSet: failed. uins empty, maybe exit room");
      return;
    }
    paramArrayList = new HeadSetViewModule.1(this, paramArrayList);
    ThreadManager.getUIHandlerV2().post(paramArrayList);
  }
  
  private void ez(ArrayList<String> paramArrayList)
  {
    if (paramArrayList.size() == 1) {
      this.Up.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getResources().getString(2131695464));
    }
    for (;;)
    {
      aitz.p(this.Up, "" + this.Up.getText());
      return;
      paramArrayList = paramArrayList.size() + this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getString(2131695488);
      this.Up.setText(paramArrayList);
    }
  }
  
  private void initData() {}
  
  private void initView()
  {
    ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getWindow());
    ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicFragmentActivity.getWindow(), true);
  }
  
  public void I(TextView paramTextView)
  {
    this.Up = paramTextView;
  }
  
  public void a(aiun paramaiun)
  {
    this.jdField_a_of_type_Aiun = paramaiun;
  }
  
  public void f(LocationRoom.b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = paramb;
  }
  
  void lj(List<aiqn> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((aiqn)paramList.next()).getUin()));
    }
    ey(localArrayList);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dug();
      continue;
      duf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airi
 * JD-Core Version:    0.7.0.1
 */