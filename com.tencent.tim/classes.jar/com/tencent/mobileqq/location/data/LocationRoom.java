package com.tencent.mobileqq.location.data;

import aiqn;
import aiqo;
import aiqs;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData;
import com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class LocationRoom
{
  private aiqn jdField_a_of_type_Aiqn;
  private Venue jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  private volatile a jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a;
  private b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private LinkedHashMap<String, aiqn> ae;
  private volatile CameraPosition b;
  private volatile boolean clA;
  private volatile boolean clB;
  private int deV = -1;
  private int deW;
  
  public LocationRoom(b paramb, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = paramb;
    this.ae = new LinkedHashMap();
    this.jdField_a_of_type_Aiqn = new aiqn(paramString, null, 0.0D);
  }
  
  public int FT()
  {
    return this.deV;
  }
  
  public int FU()
  {
    int i = this.deW;
    this.deW = (i + 1);
    return i;
  }
  
  public void Lr(boolean paramBoolean)
  {
    this.clA = paramBoolean;
  }
  
  public void Ls(boolean paramBoolean)
  {
    this.clB = paramBoolean;
  }
  
  public void Qh(int paramInt)
  {
    this.deV = paramInt;
  }
  
  public aiqn a()
  {
    return this.jdField_a_of_type_Aiqn;
  }
  
  public aiqn a(String paramString)
  {
    return (aiqn)this.ae.get(paramString);
  }
  
  public Venue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
  }
  
  public b a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  }
  
  public void a(QQAppInterface paramQQAppInterface, CameraPosition paramCameraPosition)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, "onLeaveMapPage: invoked. lastCameraPosition: " + paramCameraPosition);
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a = null;
    Lr(false);
    a(null);
    if (aiqs.a(paramQQAppInterface).apB())
    {
      this.b = paramCameraPosition;
      return;
    }
    this.b = null;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a = parama;
  }
  
  public boolean a(b paramb)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.equals(paramb);
  }
  
  public boolean apy()
  {
    return this.clA;
  }
  
  public boolean apz()
  {
    return this.clB;
  }
  
  public CameraPosition b()
  {
    return this.b;
  }
  
  public void b(LatLng paramLatLng, Double paramDouble)
  {
    this.jdField_a_of_type_Aiqn.a(paramLatLng, paramDouble);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof LocationRoom)) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.equals(((LocationRoom)paramObject).jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b);
  }
  
  public List<LatLng> fq()
  {
    if ((this.jdField_a_of_type_Aiqn == null) || (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.jdField_a_of_type_Aiqn.a());
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.g);
    return localArrayList;
  }
  
  public List<LatLng> fr()
  {
    ArrayList localArrayList = new ArrayList(this.ae.size());
    Iterator localIterator = this.ae.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((aiqn)localIterator.next()).a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) {
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.g);
    }
    return localArrayList;
  }
  
  public List<aiqn> fs()
  {
    ArrayList localArrayList = new ArrayList(this.ae.size() + 1);
    localArrayList.addAll(this.ae.values());
    return localArrayList;
  }
  
  public List<String> ft()
  {
    ArrayList localArrayList = new ArrayList(30);
    localArrayList.addAll(this.ae.keySet());
    return localArrayList;
  }
  
  public void li(List<aiqn> paramList)
  {
    Object localObject = this.ae.entrySet().iterator();
    aiqn localaiqn;
    while (((Iterator)localObject).hasNext())
    {
      localaiqn = (aiqn)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!paramList.contains(localaiqn))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a.LU(localaiqn.getUin());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationRoom", 2, new Object[] { "updateRoomLocation invoked. remove LocationItem: ", localaiqn + " listener: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a });
        }
        ((Iterator)localObject).remove();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType() == 0) && (this.ae.size() == 1) && (paramList.size() == 2)) {
      this.clA = true;
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (aiqn)paramList.get(i);
      int j;
      if (((aiqn)localObject).equals(this.jdField_a_of_type_Aiqn))
      {
        if (this.jdField_a_of_type_Aiqn.getZIndex() < 0)
        {
          localObject = this.jdField_a_of_type_Aiqn;
          j = this.deW;
          this.deW = (j + 1);
          ((aiqn)localObject).setZIndex(j);
        }
        if (!this.ae.values().contains(this.jdField_a_of_type_Aiqn)) {
          this.ae.put(this.jdField_a_of_type_Aiqn.getUin(), this.jdField_a_of_type_Aiqn);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localaiqn = (aiqn)this.ae.get(((aiqn)localObject).getUin());
        if (localaiqn == null)
        {
          j = this.deW;
          this.deW = (j + 1);
          ((aiqn)localObject).setZIndex(j);
          this.ae.put(((aiqn)localObject).getUin(), localObject);
        }
        else
        {
          if (localaiqn.getZIndex() < 0)
          {
            j = this.deW;
            this.deW = (j + 1);
            localaiqn.setZIndex(j);
          }
          localaiqn.a(((aiqn)localObject).a(), Double.valueOf(((aiqn)localObject).x()));
        }
      }
    }
  }
  
  public void setVenue(Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationRoom", 2, new Object[] { "[venue]setVenue invoked. venue: ", paramVenue + " mVenue: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue + " listener: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a });
    }
    if (paramVenue != null)
    {
      if (paramVenue.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t == null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
        }
      }
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t != null))
        {
          Marker localMarker = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t.get();
          this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t = null;
          if (localMarker != null) {
            localMarker.remove();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramVenue;
      } while (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a == null);
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t != null))
    {
      paramVenue = (Marker)this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t.get();
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue.t = null;
      if (paramVenue != null) {
        paramVenue.remove();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$a.dtN();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = null;
  }
  
  public static class Venue
    implements Parcelable
  {
    public static final Parcelable.Creator<Venue> CREATOR = new aiqo();
    public String address;
    public String authorUin;
    public LatLng g;
    public String name;
    public SoftReference<Marker> t;
    
    public Venue() {}
    
    public Venue(Parcel paramParcel)
    {
      this.authorUin = paramParcel.readString();
      this.name = paramParcel.readString();
      this.address = paramParcel.readString();
      this.g = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    }
    
    public static Venue a(String paramString, Poi paramPoi)
    {
      Venue localVenue = new Venue();
      localVenue.authorUin = paramString;
      localVenue.name = paramPoi.title;
      localVenue.address = paramPoi.address;
      localVenue.g = paramPoi.latLng;
      return localVenue;
    }
    
    public static Venue a(String paramString, SearchResultObject.SearchResultData paramSearchResultData)
    {
      Venue localVenue = new Venue();
      localVenue.authorUin = paramString;
      localVenue.name = paramSearchResultData.title;
      localVenue.address = paramSearchResultData.address;
      localVenue.g = paramSearchResultData.latLng;
      return localVenue;
    }
    
    public static Venue a(String paramString, SuggestionResultObject.SuggestionData paramSuggestionData)
    {
      Venue localVenue = new Venue();
      localVenue.authorUin = paramString;
      localVenue.name = paramSuggestionData.title;
      localVenue.address = paramSuggestionData.address;
      localVenue.g = paramSuggestionData.latLng;
      return localVenue;
    }
    
    public static Venue a(String paramString, LBSShare.POI paramPOI)
    {
      Venue localVenue = new Venue();
      localVenue.authorUin = paramString;
      localVenue.name = paramPOI.name.get();
      localVenue.address = paramPOI.addr.get();
      localVenue.g = new LatLng(paramPOI.lat.get() / 1000000.0D, paramPOI.lng.get() / 1000000.0D);
      return localVenue;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Venue))
      {
        paramObject = (Venue)paramObject;
        return this.g.equals(paramObject.g);
      }
      return super.equals(paramObject);
    }
    
    @NonNull
    public String toString()
    {
      return "Venue{ name = " + this.name + " address: " + this.address + " authorUin: " + this.authorUin + " point: " + this.g + " marker: " + this.t + " }";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.authorUin);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.address);
      paramParcel.writeParcelable(this.g, paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void LU(String paramString);
    
    public abstract void a(LocationRoom.Venue paramVenue);
    
    public abstract void dtN();
  }
  
  public static class b
  {
    private String aUf;
    private int mSessionType;
    
    public b(int paramInt, String paramString)
    {
      this.mSessionType = paramInt;
      this.aUf = paramString;
    }
    
    public boolean K(int paramInt, String paramString)
    {
      return (this.mSessionType == paramInt) && (this.aUf.equals(paramString));
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (!(paramObject instanceof b)) {}
      do
      {
        return false;
        paramObject = (b)paramObject;
      } while ((this.mSessionType != paramObject.getSessionType()) || (!this.aUf.equals(paramObject.xc())));
      return true;
    }
    
    public int getSessionType()
    {
      return this.mSessionType;
    }
    
    public int hashCode()
    {
      return this.mSessionType + this.aUf.hashCode();
    }
    
    @NonNull
    public String toString()
    {
      return "RoomKey{mHashCode='" + hashCode() + ", mSessionType=" + this.mSessionType + ", mSessionUin=" + this.aUf + '}';
    }
    
    public String xc()
    {
      return this.aUf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationRoom
 * JD-Core Version:    0.7.0.1
 */