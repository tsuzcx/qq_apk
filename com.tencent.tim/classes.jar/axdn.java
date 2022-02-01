import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class axdn
{
  public static final List<String> Mw = Arrays.asList(new String[] { acfp.m(2131702140), acfp.m(2131702151), acfp.m(2131702149), acfp.m(2131702156), acfp.m(2131702160), acfp.m(2131702157), "dbq", "886", acfp.m(2131702154), acfp.m(2131702153), acfp.m(2131702144), "ok", "666", acfp.m(2131702146), acfp.m(2131702163), acfp.m(2131702155) });
  private axdw jdField_a_of_type_Axdw;
  private axfj jdField_a_of_type_Axfj;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private StaggeredGridLayoutManager b;
  private String cTV;
  private boolean duj;
  private int eEI;
  private ArrayList<String> mData;
  private ImageView mImageView;
  private ProgressBar mProgressBar;
  private RecyclerView mRecyclerView;
  private TextView mTextView;
  private RelativeLayout nS;
  private HashMap<String, String> qZ;
  
  public axdn(BaseVMPeakActivity paramBaseVMPeakActivity, RelativeLayout paramRelativeLayout, AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = paramBaseVMPeakActivity;
    this.nS = paramRelativeLayout;
    if (this.nS != null)
    {
      this.mTextView = ((TextView)this.nS.findViewById(2131374696));
      this.mProgressBar = ((ProgressBar)this.nS.findViewById(2131378518));
      this.mRecyclerView = ((RecyclerView)this.nS.findViewById(2131374697));
      this.mImageView = ((ImageView)this.nS.findViewById(2131374693));
    }
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = paramAEGIFOutlineTextView;
    this.qZ = new HashMap();
    this.qZ.put("happy", acfp.m(2131702165));
    this.qZ.put("neutral", acfp.m(2131702141));
    this.qZ.put("sad", acfp.m(2131702147));
    this.qZ.put("anger", acfp.m(2131702158));
    this.qZ.put("disgust", acfp.m(2131702150));
    this.qZ.put("fear", acfp.m(2131702145));
  }
  
  private void bH(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(paramString1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    int i;
    if (paramString1.indexOf('\n') > 0)
    {
      i = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
      if (paramString1.indexOf('\n') <= 0) {
        break label137;
      }
    }
    label137:
    for (float f = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);; f = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F))
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(f);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.invalidate();
      return;
      i = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F);
      break;
    }
  }
  
  private void biN()
  {
    this.jdField_a_of_type_Axfj = ((axfj)awuh.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, axyw.a()).b(axfj.class));
  }
  
  public String HK()
  {
    return this.cTV;
  }
  
  public int Ra()
  {
    return this.eEI;
  }
  
  public void acq(String paramString)
  {
    this.cTV = paramString;
    if ((!this.mData.contains(paramString)) && (this.jdField_a_of_type_Axdw != null)) {
      this.jdField_a_of_type_Axdw.clearSelection();
    }
    acr(paramString);
    this.mImageView.setImageResource(2130840614);
  }
  
  public void acr(String paramString)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(paramString);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    AEGIFOutlineTextView localAEGIFOutlineTextView = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
    float f;
    if (paramString.indexOf('\n') > 0)
    {
      f = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);
      localAEGIFOutlineTextView.setTextSize(f);
      if (paramString.indexOf('\n') <= 0) {
        break label114;
      }
    }
    label114:
    for (int i = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);; i = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F))
    {
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      return;
      f = aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F);
      break;
    }
  }
  
  public void adI(int paramInt)
  {
    this.eEI = paramInt;
  }
  
  public void bG(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
    acq(paramString1);
  }
  
  public void bxo()
  {
    Log.d("AEGIFTextMvp", "On loading...");
    this.mProgressBar.setVisibility(0);
    this.mData = new ArrayList();
    eIZ();
    this.jdField_a_of_type_Axfj.l().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new axdq(this));
  }
  
  public void cU(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(paramBoolean1);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(paramBoolean2);
  }
  
  public void eIY()
  {
    Log.d("AEGIFTextMvp", "On loading completed...");
    this.mProgressBar.setVisibility(4);
    this.jdField_a_of_type_Axdw = new axdw(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this);
    this.jdField_a_of_type_Axdw.setHasStableIds(true);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_Axdw);
    this.mRecyclerView.setClipToPadding(false);
    this.mRecyclerView.setClipChildren(false);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.addOnScrollListener(new axdo(this));
    this.mImageView.setVisibility(0);
    this.mImageView.setOnClickListener(new axdp(this));
  }
  
  public void eIZ()
  {
    Log.d("AEGIFTextMvp", "Clearing smart text");
    this.mImageView.setImageResource(2130840615);
    if (this.jdField_a_of_type_Axdw != null) {
      this.jdField_a_of_type_Axdw.clearSelection();
    }
    this.cTV = "";
    this.eEI = 0;
    cU(false, true);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
    bH(acfp.m(2131702161), "#ccffffff", "#000000");
  }
  
  public ArrayList<axdk> getData()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mData.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new axdk((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public void init()
  {
    this.cTV = "";
    this.b = new StaggeredGridLayoutManager(2, 0);
    this.b.setGapStrategy(0);
    this.mRecyclerView.setLayoutManager(this.b);
    this.mRecyclerView.setItemAnimator(null);
    this.mRecyclerView.setVisibility(4);
    this.mImageView.setVisibility(4);
    biN();
    bxo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdn
 * JD-Core Version:    0.7.0.1
 */