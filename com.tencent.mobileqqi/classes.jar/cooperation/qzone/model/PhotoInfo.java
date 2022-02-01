package cooperation.qzone.model;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.common.galleryactivity.GalleryImage;
import icn;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

public class PhotoInfo
  extends GalleryImage
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new icn();
  public int a;
  public long a;
  public GpsInfo4LocalImage a;
  public PictureCutInfo a;
  public String a;
  public Map a;
  private WeakReference a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  private WeakReference b;
  public boolean b;
  public String c = "";
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f = "";
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j = -1;
  public int k;
  
  public PhotoInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_h_of_type_Int = 1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo != null) {
      return this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (Drawable)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramDrawable);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return (paramBoolean) || (this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo.jdField_b_of_type_Int != 1);
  }
  
  public Rect b()
  {
    if (this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo != null) {
      return this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo.jdField_a_of_type_AndroidGraphicsRect;
    }
    return null;
  }
  
  public Drawable b()
  {
    if (this.jdField_b_of_type_MqqUtilWeakReference != null) {
      return (Drawable)this.jdField_b_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void b(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramDrawable);
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo != null) {
      return this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo.c;
    }
    return 0;
  }
  
  public Drawable c()
  {
    Drawable localDrawable2 = b();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = a();
    }
    return localDrawable1;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo != null) {
      return this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo.d;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    int m;
    if (this.jdField_a_of_type_Boolean)
    {
      m = 1;
      paramParcel.writeInt(m);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.j);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelPictureCutInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage, paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label200;
      }
    }
    label200:
    for (paramInt = n;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      return;
      m = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */