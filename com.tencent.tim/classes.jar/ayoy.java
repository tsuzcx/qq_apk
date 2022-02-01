import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobSegment;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayoy
  extends aygy
  implements DialogInterface.OnDismissListener, aydk
{
  private float FA;
  private float FB;
  private float Fz;
  private aypb jdField_a_of_type_Aypb;
  @Nullable
  private aypc.b jdField_a_of_type_Aypc$b;
  private int eMx = -1;
  private float kt;
  
  public ayoy(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private String a(aypc.b paramb)
  {
    int i = -1;
    switch (this.eMx)
    {
    }
    for (;;)
    {
      ayjt.a locala = (ayjt.a)b().a();
      if (locala == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        paramb = new JSONArray(Arrays.asList(paramb.jn));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", paramb);
        paramb = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(rpq.getWindowScreenWidth(getContext())), Integer.valueOf(rpq.getWindowScreenHeight(getContext())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(locala.width * locala.scaleValue), Float.valueOf(locala.height * locala.scaleValue) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(locala.centerP.x + locala.translateXValue), Float.valueOf(locala.centerP.y + locala.translateYValue) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", paramb);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", locala.nI);
        localJSONObject1.put("a", localJSONObject2);
        paramb = localJSONObject1.toString();
        return paramb;
      }
      catch (JSONException paramb)
      {
        ram.e("Q.qqstory.publish.editEditVideoInteract", paramb.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void afr(int paramInt)
  {
    if ((this.jdField_a_of_type_Aypb != null) && (this.jdField_a_of_type_Aypb.isShowing())) {
      bF();
    }
    this.jdField_a_of_type_Aypb = new aypb(getContext(), this, paramInt);
    this.jdField_a_of_type_Aypb.a(a());
    this.jdField_a_of_type_Aypb.setContentView(2131562043);
    this.jdField_a_of_type_Aypb.setOnDismissListener(this);
    this.jdField_a_of_type_Aypb.show();
  }
  
  private void bF()
  {
    if ((this.jdField_a_of_type_Aypb != null) && (this.jdField_a_of_type_Aypb.isShowing()))
    {
      this.jdField_a_of_type_Aypb.dismiss();
      this.jdField_a_of_type_Aypb = null;
    }
  }
  
  public aypc.b a()
  {
    switch (this.eMx)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Aypc$b;
  }
  
  public JobSegment<ayqb, ayqb> a(int paramInt)
  {
    if (((this.b.a.a instanceof EditTakeVideoSource)) || ((this.b.a.a instanceof EditLocalVideoSource))) {
      return new ayqn(this);
    }
    return new ayqf(this);
  }
  
  public void a(int paramInt, aypc.b paramb)
  {
    this.eMx = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = paramb.bitmap;
      b().a(localBitmap, paramb.d, paramb.jn, this.kt, this.Fz, this.FA, this.FB);
      return;
      this.jdField_a_of_type_Aypc$b = paramb;
    }
  }
  
  public void a(Bundle paramBundle, aypc.b paramb)
  {
    int i = paramBundle.getInt("interact_type");
    this.kt = paramBundle.getFloat("scale");
    this.Fz = paramBundle.getFloat("rotate");
    this.FA = paramBundle.getFloat("translateX");
    this.FB = paramBundle.getFloat("translateY");
    a(i, paramb);
  }
  
  public void a(ayjt.a parama, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    ayil.a(localBundle, parama);
    localBundle.putInt("interact_type", this.eMx);
    this.b.r(38, localBundle);
    parama.aIq = false;
  }
  
  public boolean aQU()
  {
    if (this.eMx == -1) {
      return true;
    }
    aypc.b localb = a();
    if (localb == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localb.jn.length) || (TextUtils.isEmpty(localb.jn[i])))
      {
        if (i != localb.jn.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    aqha.a(getContext(), 230, acfp.m(2131705564), null, acfp.m(2131705628), acfp.m(2131705584), new ayoz(this), new aypa(this)).show();
    return false;
  }
  
  public Bitmap aX()
  {
    ayjt localayjt = b();
    if (localayjt.isEmpty()) {}
    for (;;)
    {
      return null;
      int i = localayjt.drawRect.width();
      int j = localayjt.drawRect.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localayjt.draw(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ram.e("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public ayjt b()
  {
    Object localObject = (aydg)a(aydg.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((aydg)localObject).a().b();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public void b(int paramInt, ayqb paramayqb)
  {
    aypc.b localb = a();
    if (localb != null)
    {
      ((axpx)axov.a(15)).aq(null);
      String str = a(localb);
      if (!TextUtils.isEmpty(str))
      {
        ram.b("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        paramayqb.g.putExtra("i_l", str);
        rar.a("video_edit", "pub_vote", 2, 0, new String[] { localb.jn[0] });
        rar.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    ram.b("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.eMx));
  }
  
  public void b(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.eMx = 1001;
    this.jdField_a_of_type_Aypc$b = new aypc.b(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    b().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void eQK()
  {
    switch (this.eMx)
    {
    default: 
      ram.w("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.eMx) });
    }
    for (;;)
    {
      this.eMx = -1;
      return;
      this.jdField_a_of_type_Aypc$b = null;
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.jdField_a_of_type_Aypb != null) && (this.jdField_a_of_type_Aypb.isShowing()))
    {
      bF();
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a(aydk.class, this);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.b.changeState(0);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      bF();
      return;
    }
    int i = -1;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        this.kt = paramObject.getFloat("scale");
        this.Fz = paramObject.getFloat("rotate");
        this.FA = paramObject.getFloat("translateX");
        this.FB = paramObject.getFloat("translateY");
        paramInt = paramObject.getInt("interact_type");
      }
    }
    if (paramInt != 1001) {
      throw new IllegalArgumentException("unSupport paster type:" + paramInt);
    }
    afr(paramInt);
    b().eSm();
    rar.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoy
 * JD-Core Version:    0.7.0.1
 */