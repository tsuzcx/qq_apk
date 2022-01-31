package com.tencent.biz.qrcode;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.HexUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class QRActionEntity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 4;
  public static final int k = 5;
  public static final int l = 6;
  public static final int m = 7;
  public static final int n = 1;
  public static final int o = 1;
  public ArrayList a = null;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  
  public QRActionEntity()
  {
    this.a = new ArrayList();
  }
  
  public QRActionEntity(String paramString)
  {
    a(paramString);
  }
  
  public static QRActionEntity a(int paramInt, String paramString)
  {
    long l1;
    byte[] arrayOfByte;
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      if (paramString != null)
      {
        l1 = Long.parseLong(paramString);
        paramString = new QRActionEntity();
        paramString.p = 1;
        paramString.q = 1;
        paramString.r = paramInt;
        paramString.s = 0;
        paramString.a = new ArrayList();
        arrayOfByte = QRUtils.a(l1);
        localObject = ByteBuffer.allocate(4);
        ((ByteBuffer)localObject).put(arrayOfByte, 4, 4);
        ((ByteBuffer)localObject).flip();
        arrayOfByte = new byte[((ByteBuffer)localObject).limit()];
        ((ByteBuffer)localObject).get(arrayOfByte);
        if (paramInt != 2) {
          break label145;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      localObject = new QRActionEntity.QRActionTLV(paramInt, (short)4, arrayOfByte);
      paramString.a.add(localObject);
      return paramString;
      l1 = 0L;
      break;
      label145:
      if (paramInt == 3)
      {
        paramInt = 7;
        continue;
        return null;
      }
      else
      {
        paramInt = 1;
      }
    }
  }
  
  public int a()
  {
    if (this.a != null) {
      return this.a.size();
    }
    return 0;
  }
  
  public QRActionEntity.QRActionTLV a()
  {
    if ((this.a != null) && (!this.a.isEmpty())) {
      return (QRActionEntity.QRActionTLV)this.a.get(0);
    }
    return null;
  }
  
  public QRActionEntity.QRActionTLV a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() >= paramInt)) {
      return (QRActionEntity.QRActionTLV)this.a.get(paramInt);
    }
    return null;
  }
  
  public String a()
  {
    if (this.a != null)
    {
      localObject1 = this.a.iterator();
      for (int i1 = 4;; i1 = ((QRActionEntity.QRActionTLV)((Iterator)localObject1).next()).a() + i1)
      {
        i2 = i1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      }
    }
    int i2 = 4;
    Object localObject1 = ByteBuffer.allocate(i2);
    ((ByteBuffer)localObject1).put((byte)this.p);
    ((ByteBuffer)localObject1).put((byte)this.q);
    ((ByteBuffer)localObject1).put((byte)this.r);
    ((ByteBuffer)localObject1).put((byte)this.s);
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      ((ByteBuffer)localObject1).put((byte)this.a.size());
      localObject2 = this.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        QRActionEntity.QRActionTLV localQRActionTLV = (QRActionEntity.QRActionTLV)((Iterator)localObject2).next();
        ((ByteBuffer)localObject1).put((byte)localQRActionTLV.jdField_a_of_type_Int);
        ((ByteBuffer)localObject1).putShort(localQRActionTLV.jdField_a_of_type_Short);
        ((ByteBuffer)localObject1).put(localQRActionTLV.jdField_a_of_type_ArrayOfByte);
      }
    }
    ((ByteBuffer)localObject1).flip();
    Object localObject2 = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get((byte[])localObject2);
    return HexUtil.a((byte[])localObject2);
  }
  
  public void a(String paramString)
  {
    Object localObject = HexUtil.a(paramString);
    paramString = ByteBuffer.allocate(localObject.length);
    paramString.put((byte[])localObject);
    paramString.flip();
    this.p = paramString.get();
    this.q = paramString.get();
    this.r = paramString.get();
    this.s = paramString.get();
    int i2 = paramString.get();
    this.a = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = new QRActionEntity.QRActionTLV();
      ((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_Int = paramString.get();
      byte[] arrayOfByte = new byte[2];
      paramString.get(arrayOfByte);
      ((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_Short = QRUtils.a(arrayOfByte);
      arrayOfByte = new byte[((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_Short];
      paramString.get(arrayOfByte);
      ((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.a.add(localObject);
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRActionEntity
 * JD-Core Version:    0.7.0.1
 */