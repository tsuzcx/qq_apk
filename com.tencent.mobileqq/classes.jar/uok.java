import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uok
  extends RecyclerView.Adapter<uoo>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<uon> jdField_a_of_type_JavaUtilList;
  private uou jdField_a_of_type_Uou;
  private vdz jdField_a_of_type_Vdz;
  
  public uok(Context paramContext, List<uon> paramList, uou paramuou)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Uou = paramuou;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Vdz == null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      this.jdField_a_of_type_Vdz = new vdz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695145));
    }
    this.jdField_a_of_type_Vdz.show();
  }
  
  private void a(uon paramuon)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Uou != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Uou.a() != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_Uou.a().feed == null) {
          str1 = this.jdField_a_of_type_Uou.a().feed.poster_id;
        }
      }
    }
    uor.a().a(paramuon.c, str1, new uom(this));
  }
  
  private void a(uon paramuon, int paramInt)
  {
    stFeed localstFeed;
    HashMap localHashMap;
    String str;
    if (this.jdField_a_of_type_Uou != null)
    {
      localstFeed = this.jdField_a_of_type_Uou.a();
      localHashMap = new HashMap();
      localHashMap.put("qq_group_num", paramuon.c);
      str = uvt.a;
      if (localstFeed == null) {
        break label66;
      }
    }
    label66:
    for (paramuon = localstFeed.feed;; paramuon = null)
    {
      uvm.a("qqgroup_add", paramInt + 1, str, localHashMap, paramuon);
      return;
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Vdz != null) && (this.jdField_a_of_type_Vdz.isShowing())) {
      this.jdField_a_of_type_Vdz.dismiss();
    }
  }
  
  public uoo a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560018, paramViewGroup, false);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = ((int)paramViewGroup.getContext().getResources().getDimension(2131296602));
    localView.setLayoutParams(localLayoutParams);
    return new uoo(localView);
  }
  
  public void a(uoo paramuoo, int paramInt)
  {
    uon localuon = (uon)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    uyo.a(this.jdField_a_of_type_AndroidContentContext, paramuoo.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, localuon.a());
    paramuoo.jdField_a_of_type_AndroidWidgetTextView.setText(localuon.b());
    paramuoo.b.setOnClickListener(new uol(this, localuon, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramuoo, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uok
 * JD-Core Version:    0.7.0.1
 */