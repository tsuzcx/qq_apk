import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListViewItemTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class eym
  implements View.OnLongClickListener
{
  public eym(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopListAdapter2.TroopListViewItemTag)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        paramView = (TroopListAdapter2.TroopListViewItemTag)paramView;
      } while ((paramView.a == null) || (paramView.a.a == null));
      localObject = paramView.a.a;
    } while (localObject == null);
    boolean bool = ((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).h(((TroopInfo)localObject).troopuin);
    if (bool) {}
    for (paramView = this.a.jdField_a_of_type_AndroidContentContext.getString(2131560396);; paramView = this.a.jdField_a_of_type_AndroidContentContext.getString(2131560395))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.c(this.a.jdField_a_of_type_AndroidContentContext, 230, null, null, 2131561746, 2131561875, null, null);
      localQQCustomDialog.setTitle(paramView);
      localQQCustomDialog.setMessage(paramView);
      localQQCustomDialog.setDividerGone();
      paramView = new eyn(this, bool, (TroopInfo)localObject);
      localObject = new eyo(this);
      localQQCustomDialog.setPositiveButton(2131562539, paramView);
      localQQCustomDialog.setNegativeButton(2131561746, (DialogInterface.OnClickListener)localObject);
      localQQCustomDialog.show();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eym
 * JD-Core Version:    0.7.0.1
 */