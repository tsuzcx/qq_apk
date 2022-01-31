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

public class dpg
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  public dpg(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.b, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
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
    String str1 = this.a.getString(2131560429);
    String str2 = ((TroopGagMgr)this.a.b.getManager(44)).a(this.a, paramLong);
    if (!TextUtils.isEmpty(str2)) {
      return str1 + str2;
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
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903382, paramViewGroup, false);
        paramViewGroup = new dph(this, null);
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131231773));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231090));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131232386));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131232387));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject = (FacePreloadBaseAdapter.FaceInfo)a(paramInt);
        paramViewGroup.c.setImageBitmap(a(((FacePreloadBaseAdapter.FaceInfo)localObject).jdField_a_of_type_Int, ((FacePreloadBaseAdapter.FaceInfo)localObject).jdField_a_of_type_JavaLangString));
        localObject = (TroopGagActivity.GagMemInfo)getItem(paramInt);
        if ((TextUtils.isEmpty(((TroopGagActivity.GagMemInfo)localObject).b)) || (((TroopGagActivity.GagMemInfo)localObject).b.equals(((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString))) {
          ((TroopGagActivity.GagMemInfo)localObject).b = ((FriendsManagerImp)this.a.b.getManager(8)).b(this.a.jdField_a_of_type_JavaLangString, ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopGagActivity.GagMemInfo)localObject).b);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
        paramViewGroup.b.setText(a(((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_Long));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString;
        if ((!TroopGagActivity.a(this.a, this.a.b.a())) && ((TroopGagActivity.b(this.a, ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, ((TroopGagActivity.GagMemInfo)localObject).jdField_a_of_type_JavaLangString)))) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if (paramInt <= 1) {
          break;
        }
        paramView.setBackgroundResource(2130837879);
        return paramView;
        paramViewGroup = (dph)paramView.getTag();
      }
      paramView.setBackgroundResource(2130837882);
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
    ((TroopGagMgr)this.a.b.getManager(44)).a(this.a.jdField_a_of_type_JavaLangString, str, 0L);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramView);
    notifyDataSetChanged();
    ReportController.b(this.a.b, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, this.a.jdField_a_of_type_JavaLangString + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpg
 * JD-Core Version:    0.7.0.1
 */