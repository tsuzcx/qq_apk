import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;
import com.tencent.mobileqq.armap.sensor.rotation.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class advh
{
  private advj jdField_a_of_type_Advj = new advj();
  private Vector3 jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3 = new Vector3();
  private Matrix4 jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
  private Vector3 jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector3 = new Vector3();
  private Matrix4 jdField_c_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
  private Vector3 jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3 = new Vector3();
  private Vector3 d = new Vector3();
  private Vector3 e = new Vector3();
  private Vector3 f = new Vector3();
  private Vector3 g = new Vector3();
  private Vector3 h = new Vector3();
  private Vector3 i = new Vector3();
  private Vector3 j = new Vector3();
  private Vector3 k = new Vector3();
  private ArrayList<Vector3> uN = new ArrayList(793);
  private ArrayList<Vector3> uO;
  private List<Vector3> yt = new ArrayList();
  
  public advh()
  {
    this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.setToOrtho2D(0.0F, 0.0F, 1.0F, -1.0F);
    int m = 0;
    while (m < 792)
    {
      this.uN.add(new Vector3());
      m += 1;
    }
    this.yt.addAll(this.uN);
    this.yt.add(this.e);
    this.yt.add(this.f);
    this.yt.add(this.g);
  }
  
  private void cUD()
  {
    this.e.set(0.0F, 0.0F, 1.0F);
    this.f.set(0.0F, 0.0F, -1.0F);
    if (this.uO == null)
    {
      this.uO = new ArrayList(793);
      m = 0;
      while (m < 11)
      {
        n = m - 5;
        float f1 = (float)Math.cos(n * 15 * 0.01745329F);
        float f2 = (float)Math.cos((90 - n * 15) * 0.01745329F);
        n = 0;
        while (n < 72)
        {
          Vector3 localVector3 = new Vector3((float)Math.sin(n * 5 * 0.01745329F) * f1 * 1.0F, -(float)Math.cos(n * 5 * 0.01745329F) * f1 * 1.0F, f2 * 1.0F);
          this.uO.add(localVector3);
          ((Vector3)this.uN.get(m * 72 + n)).set(localVector3);
          n += 1;
        }
        m += 1;
      }
    }
    int n = this.uN.size();
    int m = 0;
    while (m < n)
    {
      ((Vector3)this.uN.get(m)).set((Vector3)this.uO.get(m));
      m += 1;
    }
    this.g.set((Vector3)this.uN.get(360));
  }
  
  public void a(Matrix4 paramMatrix4, int paramInt)
  {
    cUD();
    this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.idt().mul(this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4).mul(paramMatrix4);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramMatrix4 = this.yt.iterator();
      Vector3 localVector3;
      while (paramMatrix4.hasNext())
      {
        localVector3 = (Vector3)paramMatrix4.next();
        this.jdField_a_of_type_Advj.a(localVector3.x, -localVector3.y, -localVector3.z, 0.0F);
        this.jdField_a_of_type_Advj.a(this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationMatrix4);
        localVector3.x = (this.jdField_a_of_type_Advj.x * 500.0F + 500.0F);
        localVector3.y = (this.jdField_a_of_type_Advj.y * 500.0F + 500.0F + 0.0F);
        localVector3.z = (this.jdField_a_of_type_Advj.z * 500.0F);
      }
      continue;
      paramMatrix4 = this.yt.iterator();
      while (paramMatrix4.hasNext())
      {
        localVector3 = (Vector3)paramMatrix4.next();
        this.jdField_a_of_type_Advj.a(localVector3.x, -localVector3.y, -localVector3.z, 0.0F);
        this.jdField_a_of_type_Advj.a(this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationMatrix4);
        localVector3.x = (-this.jdField_a_of_type_Advj.x * 500.0F + 500.0F);
        localVector3.y = (-this.jdField_a_of_type_Advj.y * 500.0F + 500.0F + 0.0F);
        localVector3.z = (this.jdField_a_of_type_Advj.z * 500.0F);
      }
    }
  }
  
  public void a(Matrix4 paramMatrix4, int paramInt, float[] paramArrayOfFloat)
  {
    a(paramMatrix4, paramInt);
    paramMatrix4 = this.f;
    float f5 = 3.4028235E+38F;
    this.d.set(0.5F * 1000.0F, 0.5F * 1000.0F, -1000.0F);
    this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.set(0.5F * 1000.0F, 0.5F * 1000.0F, 0.0F);
    float f6 = advi.a(this.d, this.f);
    float f7 = advi.a(this.d, this.e);
    float f4 = advi.a(this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3, this.f);
    float f2 = advi.a(this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3, this.d);
    float f1 = advi.a(this.f, this.d);
    float f3 = advi.h(f1, advi.b(f4, f2, f1)) * 57.29578F - 90.0F;
    f1 = f3;
    if (f6 > f7) {
      f1 = -f3;
    }
    if (Float.isNaN(f1)) {}
    label399:
    label594:
    label979:
    for (f3 = 0.0F;; f3 = f1)
    {
      this.d.set(0.5F * 1000.0F, 0.5F * 1000.0F, -1000.0F);
      int m;
      Vector3 localVector3;
      if (Math.abs(f3) < 75.0F)
      {
        paramInt = 0;
        m = 0;
        f1 = f5;
        if (m < 792)
        {
          localVector3 = (Vector3)this.uN.get(m);
          if (localVector3.z >= 0.0F) {
            break label1392;
          }
          f5 = advi.a(this.d, localVector3);
          if (f5 >= f1) {
            break label1392;
          }
          f1 = f5;
          paramInt = m;
        }
      }
      label853:
      label1373:
      label1379:
      label1392:
      for (;;)
      {
        m += 1;
        break;
        int n;
        if (paramInt % 72 == 0)
        {
          m = paramInt + 1;
          n = paramInt + 72 - 1;
          if ((m < 0) || (n < 0) || (m >= 792) || (n >= 792)) {
            break label1379;
          }
          f2 = advi.a(this.d, (Vector3)this.uN.get(m));
          f4 = advi.a(this.d, (Vector3)this.uN.get(n));
          if (f2 >= f4) {
            break label949;
          }
          label374:
          if (m >= paramInt) {
            break label979;
          }
          if (((paramInt + 1) % 72 != 0) || (m != n)) {
            break label960;
          }
          n = paramInt;
        }
        for (;;)
        {
          if ((m <= 791) && (m >= 0)) {
            paramMatrix4 = (Vector3)this.uN.get(m);
          }
          for (;;)
          {
            f4 = n % 72;
            f5 = advi.a((Vector3)this.uN.get(paramInt), paramMatrix4);
            double d1 = f4 * 5.0F;
            double d2 = 5.0F;
            double d3 = Math.cos(advi.i(f2, advi.b(f1, f2, f5)));
            f1 = advi.a(d1 + d2 * (f1 * d3 / f5) - 180.0D);
            f2 = f1;
            if (Float.isNaN(f1)) {
              f2 = 0.0F;
            }
            if (Math.abs(f3) < 75.0F)
            {
              this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3.set(0.5F * 1000.0F, 0.2F * 1000.0F, 0.0F);
              this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector3.set(0.5F * 1000.0F, 0.8F * 1000.0F, 0.0F);
              paramInt = 1;
              if (f3 < 0.0F)
              {
                paramInt = 0;
                localVector3 = this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector3;
                paramMatrix4 = this.e;
                f1 = (float)Math.sqrt((localVector3.x - this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.x) * (localVector3.x - this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.x) + (localVector3.y - this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.y) * (localVector3.y - this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.y));
                f4 = (float)Math.sqrt((localVector3.x - paramMatrix4.x) * (localVector3.x - paramMatrix4.x) + (localVector3.y - paramMatrix4.y) * (localVector3.y - paramMatrix4.y));
                f5 = (float)Math.sqrt((this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.x - paramMatrix4.x) * (this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.x - paramMatrix4.x) + (this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.y - paramMatrix4.y) * (this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3.y - paramMatrix4.y));
                if ((f1 * f1 + f5 * f5 - f4 * f4) / (2.0F * f1 * f5) >= 1.0F) {
                  break label1361;
                }
                f1 = (float)Math.acos((f1 * f1 + f5 * f5 - f4 * f4) / (f1 * 2.0F * f5)) * 57.29578F;
                if (paramInt == 0) {
                  break label1319;
                }
                if (localVector3.x - paramMatrix4.x >= 0.0F) {
                  break label1373;
                }
                f1 = -f1;
              }
            }
            for (;;)
            {
              f1 = advi.a(f1);
              if ((f1 <= 3.0F) || (f1 >= 357.0F)) {
                f1 = 0.0F;
              }
              for (;;)
              {
                f4 = f1;
                if (Float.isNaN(f1)) {
                  f4 = 0.0F;
                }
                paramArrayOfFloat[0] = f2;
                paramArrayOfFloat[1] = f3;
                paramArrayOfFloat[2] = f4;
                return;
                if ((paramInt + 1) % 72 == 0)
                {
                  m = paramInt - 1;
                  n = paramInt - 72 - 1;
                  break;
                }
                m = paramInt + 1;
                n = paramInt - 1;
                break;
                f2 = f4;
                m = n;
                break label374;
                f4 = f1;
                n = m;
                f1 = f2;
                f2 = f4;
                break label399;
                if ((paramInt % 72 == 0) && (m == n))
                {
                  f4 = f1;
                  n = m;
                  f1 = f2;
                  f2 = f4;
                  break label399;
                }
                n = paramInt;
                break label399;
                this.h.set(0.5F * 1000.0F, 0.2F * 1000.0F + (1000.0F - 1000.0F) / 2.0F, 0.0F);
                this.i.set(0.5F * 1000.0F, 0.8F * 1000.0F + (1000.0F - 1000.0F) / 2.0F, 0.0F);
                this.j.set(0.2F * 1000.0F, 0.5F * 1000.0F, 0.0F);
                this.k.set(0.8F * 1000.0F, 0.5F * 1000.0F, 0.0F);
                f1 = advi.a(this.g, this.h);
                f6 = advi.a(this.g, this.i);
                f4 = advi.a(this.g, this.j);
                f5 = advi.a(this.g, this.k);
                f2 = advi.a(this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3, this.g);
                f7 = advi.a(this.jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector3, this.h);
                float f8 = advi.a(this.g, this.h);
                f2 = -advi.h(f8, advi.b(f2, f7, f8)) * 57.29578F;
                if (f1 < f6)
                {
                  f1 = f2;
                  if (f4 < f5) {
                    f1 = 360.0F - f2;
                  }
                }
                for (;;)
                {
                  f2 = f1;
                  if (f3 > 0.0F) {
                    f2 = 180.0F - f1;
                  }
                  f1 = advi.a(f2);
                  break;
                  if (f4 < f5) {
                    f1 = f2 + 180.0F;
                  } else {
                    f1 = 180.0F - f2;
                  }
                }
                localVector3 = this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3;
                paramMatrix4 = this.f;
                break label594;
                if (localVector3.x - paramMatrix4.x <= 0.0F) {
                  break label1373;
                }
                f1 = -f1;
                break label853;
                f1 = (float)Math.round(f1 / 0.5D) * 0.5F;
                continue;
                f1 = 0.0F;
                continue;
                f1 = 0.0F;
              }
            }
          }
          n = 0;
          m = 0;
          f1 = f4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advh
 * JD-Core Version:    0.7.0.1
 */