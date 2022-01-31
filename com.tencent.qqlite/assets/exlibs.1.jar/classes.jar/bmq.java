import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.GagMemInfo;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.List;

public class bmq
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  public bmq(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
  }
  
  protected Object a(int paramInt)
  {
    TroopGagActivity.GagMemInfo localGagMemInfo = (TroopGagActivity.GagMemInfo)getItem(paramInt);
    if (localGagMemInfo == null) {
      return null;
    }
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = localGagMemInfo.jdField_a_of_type_JavaLangString;
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  protected String a(long paramLong)
  {
    String str = ((TroopGagMgr)this.a.app.getManager(42)).a(this.a, paramLong);
    if (!TextUtils.isEmpty(str)) {
      return "" + str;
    }
    return "";
  }
  
  public int getCount()
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.a.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt > 0)
    {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903315, paramViewGroup, false);
        paramViewGroup = new bmr(this, null);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297675));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296532));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297676));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131297677));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject = (FacePreloadBaseAdapter.FaceInfo)a(paramInt);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(((FacePreloadBaseAdapter.FaceInfo)localObject).jdField_a_of_type_Int, ((FacePreloadBaseAdapter.FaceInfo)localObject).jdField_a_of_type_JavaLangString));
        localObject = (TroopGagActivity.GagMemInfo)getItem(paramInt);
        if ((TextUtils.isEmpty(((TroopGagActivity.GagMemInfo)localObject).b)) || (((TroopGagActivity.GagMemInfo)localObject).b.equals(((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString))) {
          ((TroopGagActivity.GagMemInfo)localObject).b = ((FriendsManagerImp)this.a.app.getManager(8)).a(this.a.jdField_a_of_type_JavaLangString, ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopGagActivity.GagMemInfo)localObject).b);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_Long));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString;
        if ((!TroopGagActivity.a(this.a, this.a.app.a())) && ((TroopGagActivity.b(this.a, ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString)))) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
          break;
        }
        paramView.setBackgroundResource(2130837930);
        return paramView;
        paramViewGroup = (bmr)paramView.getTag();
      }
      paramView.setBackgroundResource(2130837931);
      return paramView;
    }
    return this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopGagActivity.GagMemInfo)) {
      return;
    }
    paramView = (TroopGagActivity.GagMemInfo)paramView;
    String str = paramView.jdField_a_of_type_JavaLangString;
    TroopGagMgr localTroopGagMgr = (TroopGagMgr)this.a.app.getManager(42);
    localTroopGagMgr.a(this.a.jdField_a_of_type_JavaLangString, str, 0L);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramView);
    notifyDataSetChanged();
    ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, this.a.jdField_a_of_type_JavaLangString + "", localTroopGagMgr.a(this.a.jdField_a_of_type_JavaLangString), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmq
 * JD-Core Version:    0.7.0.1
 */