import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayub
  extends aydy
{
  private ayud jdField_a_of_type_Ayud;
  private ayuf jdField_a_of_type_Ayuf;
  private final QzoneEditPictureActivity jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity;
  private aytz b;
  public String bdK;
  public boolean bxD = true;
  public boolean bxE;
  public boolean bxH = true;
  private boolean bxq;
  public int cig = -1;
  private boolean dAS;
  public ArrayList<String> eo;
  public int fontId = -1;
  public boolean isTopic;
  public String mContent = "";
  public String mFontUrl;
  public int mPriv = 1;
  public String pO;
  public int superFontId = -1;
  public boolean topicSyncQzone = true;
  public String uO;
  public View zJ;
  
  public ayub(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity = paramQzoneEditPictureActivity;
    this.dAS = paramBoolean;
  }
  
  private ayuc a()
  {
    Iterator localIterator = getParts().iterator();
    while (localIterator.hasNext())
    {
      aygy localaygy = (aygy)localIterator.next();
      if ((localaygy instanceof ayuc)) {
        return (ayuc)localaygy;
      }
    }
    return null;
  }
  
  private void eTF()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.findViewById(2131373271);
    Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity).inflate(2131562454, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, ayxa.sNotchHeight, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131376008).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131376006).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131376009).setVisibility(8);
    localObject = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getLayoutInflater().inflate(2131562452, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(50.0F, b().getContext().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    if (ayxa.eMW > 0) {}
    for (int i = ayxa.eMW;; i = wja.dp2px(60.0F, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getResources()))
    {
      localLayoutParams.bottomMargin = i;
      View localView = new View(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity);
      localView.setBackgroundColor(Color.argb(128, 0, 0, 0));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localView.setVisibility(8);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localRelativeLayout.addView(localView);
      this.zJ = localView;
      return;
    }
  }
  
  public void ZO(boolean paramBoolean)
  {
    this.bxq = paramBoolean;
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    long l = 0xFFFFFFFF & (paramEditVideoParams.aCQ | 0x0);
    if (aRb())
    {
      super.a(new EditVideoParams(paramEditVideoParams.asi, 0xFDFFFFFF & 0xFFFDFFFF & l & 0xFBFFFFFF & 0xFFFFDFFF, paramEditVideoParams.a, paramEditVideoParams.mExtra));
      eS(this.lu);
      return;
    }
    super.a(new EditVideoParams(paramEditVideoParams.asi, l, paramEditVideoParams.a, paramEditVideoParams.mExtra));
  }
  
  public boolean aRb()
  {
    return this.dAS;
  }
  
  public boolean aRc()
  {
    return this.bxq;
  }
  
  public void afJ(int paramInt)
  {
    ayuc localayuc = a();
    if (localayuc != null) {
      localayuc.p(paramInt, null);
    }
  }
  
  public void bsV()
  {
    super.bsV();
    afJ(3006);
  }
  
  public void cF(Context paramContext)
  {
    super.cF(paramContext);
    afJ(3005);
  }
  
  protected void eS(List<aygy> paramList)
  {
    super.eS(paramList);
    if (aRb())
    {
      Object localObject = new aytz(this);
      this.b = ((aytz)localObject);
      paramList.add(localObject);
      localObject = new ayuf(this);
      this.jdField_a_of_type_Ayuf = ((ayuf)localObject);
      paramList.add(localObject);
      localObject = new ayud(this);
      this.jdField_a_of_type_Ayud = ((ayud)localObject);
      paramList.add(localObject);
    }
    try
    {
      paramList.add(new ayun(this));
      return;
    }
    catch (Exception paramList)
    {
      QZLog.e("QzEditVideoPartManager", 2, new Object[] { "addExtraParts", " add report part error" });
    }
  }
  
  public void onCreate()
  {
    if (aRb()) {
      eTF();
    }
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayub
 * JD-Core Version:    0.7.0.1
 */