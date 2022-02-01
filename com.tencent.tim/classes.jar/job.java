import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;

public class job
  extends RecyclerView.Adapter<TroopCardPopClassfic.a>
{
  public job(TroopCardPopClassfic paramTroopCardPopClassfic) {}
  
  private void a(TroopCardPopClassfic.a parama, popclassifc.PopItem paramPopItem)
  {
    parama.nk.setText(paramPopItem.str_desc.get());
    int i = aqcx.dip2px(this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity(), 48.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    parama.hi.setScaleType(ImageView.ScaleType.FIT_XY);
    parama.hi.setLayoutParams(localLayoutParams);
    paramPopItem = URLDrawable.getDrawable(paramPopItem.str_icon_url.get(), null);
    parama.hi.setImageDrawable(paramPopItem);
    if ((paramPopItem != null) && (1 != paramPopItem.getStatus())) {
      paramPopItem.restartDownload();
    }
  }
  
  public TroopCardPopClassfic.a a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131560045, null);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(this.a.mItemWidth, -2));
    return new TroopCardPopClassfic.a(paramViewGroup);
  }
  
  public void a(TroopCardPopClassfic.a parama, int paramInt)
  {
    a(parama, (popclassifc.PopItem)((popclassifc.PopCard)this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.get(paramInt));
    parama.itemView.setOnClickListener(new joc(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard != null) {
      return ((popclassifc.PopCard)this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     job
 * JD-Core Version:    0.7.0.1
 */