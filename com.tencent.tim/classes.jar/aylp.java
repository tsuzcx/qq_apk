import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;

public class aylp
  implements axqg
{
  public aylp(DoodleEditView paramDoodleEditView) {}
  
  private void c(aykk paramaykk, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.this$0.jdField_a_of_type_Ayjv.Lp()) {
      return;
    }
    paramSegmentKeeper = ayon.a(paramaykk, paramFloat1, paramFloat2, paramFloat3);
    paramaykk = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.this$0.jdField_a_of_type_Ayjv.a(), paramaykk.category, paramaykk.name, paramaykk.drawable, paramSegmentKeeper, paramString, paramaykk.eGY, false, null, null, this.this$0.getFrom());
    this.this$0.jdField_a_of_type_Ayjv.f(paramaykk);
    this.this$0.postInvalidate();
  }
  
  public void a(aykk paramaykk, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramaykk, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(ayna.c paramc, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((!this.this$0.jdField_a_of_type_Ayjv.Lp()) || (paramc == null)) {
      return;
    }
    Object localObject1 = null;
    ram.d("DoodleEditView", "addLocationFaceItem:" + paramc.toString());
    boolean bool = this.this$0.getContext() instanceof EditPicActivity;
    label70:
    Object localObject2;
    label120:
    float f1;
    float f2;
    if (bool)
    {
      paramc.eGY = 0;
      localObject2 = aynb.a(paramc, this.this$0.getContext(), -1L);
      if (!bool) {
        break label592;
      }
      if (localObject2 != null) {
        localObject1 = new BitmapDrawable(this.this$0.getContext().getResources(), ((ayob)localObject2).ba());
      }
      if (localObject1 == null) {
        break label597;
      }
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "x:" + paramFloat1);
      }
      if (!(this.this$0.jdField_a_of_type_Ayjv.b instanceof ayjn.b)) {
        break label665;
      }
      localObject2 = (ayjn.b)this.this$0.jdField_a_of_type_Ayjv.b;
      if (((ayjn.b)localObject2).scaleValue > 4.0D) {
        ((ayjn.b)localObject2).scaleValue = 1.0F;
      }
      f1 = ((ayjn.b)localObject2).centerP.x;
      f2 = ((ayjn.b)localObject2).scaleValue * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F;
      f1 = ((ayjn.b)localObject2).translateXValue + (f1 - f2);
      f2 = ((ayjn.b)localObject2).centerP.x;
      if (f1 >= azbx.dip2px(23.0F)) {
        break label662;
      }
      f2 = ((ayjn.b)localObject2).centerP.x - f1 + azbx.dip2px(23.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleEditView", 2, "startX:" + f1 + "x:" + paramFloat1);
      }
      localObject2 = new ayjn.d(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (TextUtils.isEmpty(paramString)) {
        paramString = paramc.cWb;
      }
      for (;;)
      {
        if ((localObject1 instanceof ayob)) {}
        for (paramc = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.this$0.jdField_a_of_type_Ayjv.a(), paramc.packageName, paramString, (Drawable)localObject1, (ayjn.d)localObject2, "", paramc.eGY, paramc.dAb, paramc.location, ((ayob)localObject1).getData(), this.this$0.getFrom());; paramc = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.this$0.jdField_a_of_type_Ayjv.a(), paramc.packageName, paramString, (Drawable)localObject1, (ayjn.d)localObject2, "", paramc.eGY, false, paramc.location, null, this.this$0.getFrom()))
        {
          if (((paramc instanceof ayjn.b)) && ((this.this$0.jdField_a_of_type_Ayjv.b instanceof ayjn.b))) {
            ((ayjn.b)paramc).eGZ = ((ayjn.b)this.this$0.jdField_a_of_type_Ayjv.b).eGZ;
          }
          this.this$0.jdField_a_of_type_Ayjv.f(paramc);
          paramc.centerP.x = f2;
          this.this$0.postInvalidate();
          return;
          paramc.eGY = 3;
          break label70;
          label592:
          localObject1 = localObject2;
          break label120;
          label597:
          break;
          paramc.eGY = 0;
        }
      }
      label662:
      continue;
      label665:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void a(aynd.a parama, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.this$0.jdField_a_of_type_Ayjv.Lp()) {
      return;
    }
    ayjn.d locald = ayon.a(parama, this.this$0.getWidth(), this.this$0.getHeight(), paramFloat1, paramFloat2);
    if (locald != null) {
      if ((parama.dj != null) && ((parama.dj instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)parama.dj).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          parama = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.this$0.jdField_a_of_type_Ayjv.a(), parama.packageName, parama.desc, parama.dj, locald, localFile.getAbsolutePath(), parama.eKG, false, null, null, this.this$0.getFrom());
          this.this$0.jdField_a_of_type_Ayjv.f(parama);
        }
      }
    }
    for (;;)
    {
      this.this$0.postInvalidate();
      return;
      ram.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(aynd.a parama, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void b(aykk paramaykk, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramaykk, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void eNU()
  {
    this.this$0.jdField_a_of_type_Ayjv.btS();
  }
  
  public void jR(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylp
 * JD-Core Version:    0.7.0.1
 */