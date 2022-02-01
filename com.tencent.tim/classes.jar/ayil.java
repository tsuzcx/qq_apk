import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayil
  extends aygy
  implements DialogInterface.OnDismissListener, ayio
{
  public static String cWP = "EditVideoVote";
  private float FA;
  private float FB;
  private float Fz;
  private ayil.a jdField_a_of_type_Ayil$a;
  private aytn jdField_a_of_type_Aytn;
  private float kt;
  
  public ayil(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private JSONObject a(@NonNull ayil.a parama)
  {
    aykb.b localb = a().a();
    if (localb != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(rpq.getWindowScreenWidth(getContext())), Integer.valueOf(rpq.getWindowScreenHeight(getContext())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localb.width * localb.scaleValue), Float.valueOf(localb.height * localb.scaleValue) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localb.centerP.x + localb.translateXValue), Float.valueOf(localb.centerP.y + localb.translateYValue) }));
        parama = new JSONArray(Arrays.asList(parama.jr));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localb.nI);
        localJSONObject2.put("c", parama);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parama)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoVote", parama.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, aykb.b paramb)
  {
    if (paramb != null)
    {
      paramBundle.putFloat("scale", paramb.scaleValue);
      paramBundle.putFloat("rotate", paramb.nI);
      paramBundle.putFloat("translateX", paramb.translateXValue);
      paramBundle.putFloat("translateY", paramb.translateYValue);
    }
  }
  
  private void a(ayil.a parama, int paramInt)
  {
    if (this.jdField_a_of_type_Aytn != null) {
      eRS();
    }
    this.jdField_a_of_type_Aytn = new aytn(getContext(), this, parama, paramInt);
    this.jdField_a_of_type_Aytn.setContentView(2131562043);
    this.jdField_a_of_type_Aytn.setOnDismissListener(this);
    this.jdField_a_of_type_Aytn.show();
  }
  
  private void eRS()
  {
    if ((this.jdField_a_of_type_Aytn != null) && (this.jdField_a_of_type_Aytn.isShowing()))
    {
      this.jdField_a_of_type_Aytn.dismiss();
      this.jdField_a_of_type_Aytn = null;
    }
  }
  
  public ayil.a a()
  {
    return this.jdField_a_of_type_Ayil$a;
  }
  
  @NonNull
  public aykb a()
  {
    Object localObject = (aydg)a(aydg.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((aydg)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a(Bundle paramBundle, String[] paramArrayOfString, Bitmap paramBitmap, Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      this.kt = paramBundle.getFloat("scale");
      this.Fz = paramBundle.getFloat("rotate");
      this.FA = paramBundle.getFloat("translateX");
      this.FB = paramBundle.getFloat("translateY");
    }
    a(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
  }
  
  public void a(aykb.b paramb, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Ayil$a == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.b.changeState(35);
      return;
    }
    Object localObject = new ayoo().c(paramb);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = paramb.width / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = paramb.height / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, paramb);
    ((Bundle)localObject).putInt("element_index", rpg.a(this.jdField_a_of_type_Ayil$a.g, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.b.r(35, localObject);
    paramb.aIq = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ayii == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Ayil$a = new ayil.a(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ayii == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Ayil$a = new ayil.a(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.kt, this.Fz, this.FA, this.FB);
  }
  
  public boolean aQH()
  {
    Object localObject = this.jdField_a_of_type_Ayil$a;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((ayil.a)localObject).jr.length) {
        break label115;
      }
      if (!TextUtils.isEmpty(localObject.jr[i])) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        Context localContext = getContext();
        if (i == 0) {}
        for (localObject = acfp.m(2131705498);; localObject = acfp.m(2131705577))
        {
          aqha.a(localContext, 230, (String)localObject, null, acfp.m(2131705686), acfp.m(2131705641), new ayim(this, i), new ayin(this)).show();
          return false;
          i += 1;
          break;
        }
      }
      return true;
      label115:
      i = -1;
    }
  }
  
  public void b(int paramInt, ayqb paramayqb)
  {
    ayil.a locala = this.jdField_a_of_type_Ayil$a;
    if (locala != null)
    {
      ((axpx)axov.a(15)).aq(null);
      Object localObject = a(locala);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        ram.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        paramayqb.g.putExtra("pl", localObject);
        paramayqb = new StringBuilder();
        localObject = locala.jr;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          paramayqb.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        paramayqb.deleteCharAt(paramayqb.length() - 1);
        localObject = paramayqb.toString();
        if (locala.dzo) {}
        for (paramayqb = "1";; paramayqb = "2")
        {
          rar.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, paramayqb });
          rar.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      ram.d("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    ram.d("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public void cm(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      aykb.b localb = a().a();
      if (localb != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(rpq.getWindowScreenWidth(getContext())), Integer.valueOf(rpq.getWindowScreenHeight(getContext())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localb.width * localb.scaleValue), Float.valueOf(localb.height * localb.scaleValue) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localb.centerP.x + localb.translateXValue), Float.valueOf(localb.centerP.y + localb.translateYValue) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Ayil$a.jr));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localb.h != null)
        {
          localObject1 = localObject2;
          if (localb.h.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localb.h;
            int j = arrayOfRect.length;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= j) {
                break;
              }
              localObject1 = arrayOfRect[i];
              ((JSONArray)localObject2).put(localObject1.left);
              ((JSONArray)localObject2).put(localObject1.top);
              ((JSONArray)localObject2).put(localObject1.right);
              ((JSONArray)localObject2).put(localObject1.bottom);
              i += 1;
            }
          }
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ss", localJSONArray1);
        ((JSONObject)localObject2).put("ls", localJSONArray2);
        ((JSONObject)localObject2).put("lp", localJSONArray3);
        ((JSONObject)localObject2).put("r", localb.nI);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(cWP, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void eRT()
  {
    this.jdField_a_of_type_Ayil$a = null;
    ram.d("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public boolean onBackPressed()
  {
    if ((this.jdField_a_of_type_Aytn != null) && (this.jdField_a_of_type_Aytn.isShowing()))
    {
      eRS();
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a(ayio.class, this);
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
      eRS();
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
        paramInt = paramObject.getInt("element_index");
        this.kt = paramObject.getFloat("scale");
        this.Fz = paramObject.getFloat("rotate");
        this.FA = paramObject.getFloat("translateX");
        this.FB = paramObject.getFloat("translateY");
      }
    }
    a(this.jdField_a_of_type_Ayil$a, paramInt);
    a().eSm();
    rar.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public static class a
  {
    public final boolean dzo;
    public final Rect[] g;
    public final Bitmap hC;
    public final String[] jr;
    
    public a(String[] paramArrayOfString, Bitmap paramBitmap, Rect[] paramArrayOfRect, boolean paramBoolean)
    {
      this.jr = paramArrayOfString;
      this.hC = paramBitmap;
      this.g = paramArrayOfRect;
      this.dzo = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayil
 * JD-Core Version:    0.7.0.1
 */