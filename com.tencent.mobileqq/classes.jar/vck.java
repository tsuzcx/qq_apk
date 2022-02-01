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

public class vck
  extends RecyclerView.Adapter<vco>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<vcn> jdField_a_of_type_JavaUtilList;
  private vcu jdField_a_of_type_Vcu;
  private vss jdField_a_of_type_Vss;
  
  public vck(Context paramContext, List<vcn> paramList, vcu paramvcu)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Vcu = paramvcu;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Vss == null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      this.jdField_a_of_type_Vss = new vss(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695361));
    }
    this.jdField_a_of_type_Vss.show();
  }
  
  private void a(vcn paramvcn)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Vcu != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Vcu.a() != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_Vcu.a().feed == null) {
          str1 = this.jdField_a_of_type_Vcu.a().feed.poster_id;
        }
      }
    }
    vcr.a().a(paramvcn.c, str1, new vcm(this));
  }
  
  private void a(vcn paramvcn, int paramInt)
  {
    stFeed localstFeed;
    HashMap localHashMap;
    String str;
    if (this.jdField_a_of_type_Vcu != null)
    {
      localstFeed = this.jdField_a_of_type_Vcu.a();
      localHashMap = new HashMap();
      localHashMap.put("qq_group_num", paramvcn.c);
      str = vkh.a;
      if (localstFeed == null) {
        break label66;
      }
    }
    label66:
    for (paramvcn = localstFeed.feed;; paramvcn = null)
    {
      vka.a("qqgroup_add", paramInt + 1, str, localHashMap, paramvcn);
      return;
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Vss != null) && (this.jdField_a_of_type_Vss.isShowing())) {
      this.jdField_a_of_type_Vss.dismiss();
    }
  }
  
  public vco a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560062, paramViewGroup, false);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = ((int)paramViewGroup.getContext().getResources().getDimension(2131296602));
    localView.setLayoutParams(localLayoutParams);
    return new vco(localView);
  }
  
  public void a(vco paramvco, int paramInt)
  {
    vcn localvcn = (vcn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    vnd.a(this.jdField_a_of_type_AndroidContentContext, paramvco.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, localvcn.a());
    paramvco.jdField_a_of_type_AndroidWidgetTextView.setText(localvcn.b());
    paramvco.b.setOnClickListener(new vcl(this, localvcn, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramvco, paramInt, getItemId(paramInt));
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
 * Qualified Name:     vck
 * JD-Core Version:    0.7.0.1
 */