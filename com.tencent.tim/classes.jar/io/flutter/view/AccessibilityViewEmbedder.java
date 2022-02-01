package io.flutter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

final class AccessibilityViewEmbedder
{
  private static final String TAG = "AccessibilityBridge";
  private final Map<View, Rect> embeddedViewToDisplayBounds;
  private final SparseArray<ViewAndId> flutterIdToOrigin = new SparseArray();
  private int nextFlutterId;
  private final Map<ViewAndId, Integer> originToFlutterId;
  private final ReflectionAccessors reflectionAccessors = new ReflectionAccessors(null);
  private final View rootAccessibilityView;
  
  AccessibilityViewEmbedder(@NonNull View paramView, int paramInt)
  {
    this.rootAccessibilityView = paramView;
    this.nextFlutterId = paramInt;
    this.originToFlutterId = new HashMap();
    this.embeddedViewToDisplayBounds = new HashMap();
  }
  
  private void addChildrenToFlutterNode(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull View paramView, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    int i = 0;
    while (i < paramAccessibilityNodeInfo1.getChildCount())
    {
      Object localObject = this.reflectionAccessors.getChildId(paramAccessibilityNodeInfo1, i);
      if (localObject == null)
      {
        i += 1;
      }
      else
      {
        int k = ReflectionAccessors.getVirtualNodeId(((Long)localObject).longValue());
        localObject = new ViewAndId(paramView, k, null);
        int j;
        if (this.originToFlutterId.containsKey(localObject)) {
          j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
        }
        for (;;)
        {
          paramAccessibilityNodeInfo2.addChild(this.rootAccessibilityView, j);
          break;
          j = this.nextFlutterId;
          this.nextFlutterId = (j + 1);
          cacheVirtualIdMappings(paramView, k, j);
        }
      }
    }
  }
  
  private void cacheVirtualIdMappings(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    paramView = new ViewAndId(paramView, paramInt1, null);
    this.originToFlutterId.put(paramView, Integer.valueOf(paramInt2));
    this.flutterIdToOrigin.put(paramInt2, paramView);
  }
  
  @NonNull
  private AccessibilityNodeInfo convertToFlutterNode(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, @NonNull View paramView)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    localAccessibilityNodeInfo.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityNodeInfo.setSource(this.rootAccessibilityView, paramInt);
    localAccessibilityNodeInfo.setClassName(paramAccessibilityNodeInfo.getClassName());
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(paramView);
    copyAccessibilityFields(paramAccessibilityNodeInfo, localAccessibilityNodeInfo);
    setFlutterNodesTranslateBounds(paramAccessibilityNodeInfo, localRect, localAccessibilityNodeInfo);
    addChildrenToFlutterNode(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    setFlutterNodeParent(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    return localAccessibilityNodeInfo;
  }
  
  private void copyAccessibilityFields(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    paramAccessibilityNodeInfo2.setAccessibilityFocused(paramAccessibilityNodeInfo1.isAccessibilityFocused());
    paramAccessibilityNodeInfo2.setCheckable(paramAccessibilityNodeInfo1.isCheckable());
    paramAccessibilityNodeInfo2.setChecked(paramAccessibilityNodeInfo1.isChecked());
    paramAccessibilityNodeInfo2.setContentDescription(paramAccessibilityNodeInfo1.getContentDescription());
    paramAccessibilityNodeInfo2.setEnabled(paramAccessibilityNodeInfo1.isEnabled());
    paramAccessibilityNodeInfo2.setClickable(paramAccessibilityNodeInfo1.isClickable());
    paramAccessibilityNodeInfo2.setFocusable(paramAccessibilityNodeInfo1.isFocusable());
    paramAccessibilityNodeInfo2.setFocused(paramAccessibilityNodeInfo1.isFocused());
    paramAccessibilityNodeInfo2.setLongClickable(paramAccessibilityNodeInfo1.isLongClickable());
    paramAccessibilityNodeInfo2.setMovementGranularities(paramAccessibilityNodeInfo1.getMovementGranularities());
    paramAccessibilityNodeInfo2.setPassword(paramAccessibilityNodeInfo1.isPassword());
    paramAccessibilityNodeInfo2.setScrollable(paramAccessibilityNodeInfo1.isScrollable());
    paramAccessibilityNodeInfo2.setSelected(paramAccessibilityNodeInfo1.isSelected());
    paramAccessibilityNodeInfo2.setText(paramAccessibilityNodeInfo1.getText());
    paramAccessibilityNodeInfo2.setVisibleToUser(paramAccessibilityNodeInfo1.isVisibleToUser());
    if (Build.VERSION.SDK_INT >= 18) {
      paramAccessibilityNodeInfo2.setEditable(paramAccessibilityNodeInfo1.isEditable());
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAccessibilityNodeInfo2.setCanOpenPopup(paramAccessibilityNodeInfo1.canOpenPopup());
      paramAccessibilityNodeInfo2.setCollectionInfo(paramAccessibilityNodeInfo1.getCollectionInfo());
      paramAccessibilityNodeInfo2.setCollectionItemInfo(paramAccessibilityNodeInfo1.getCollectionItemInfo());
      paramAccessibilityNodeInfo2.setContentInvalid(paramAccessibilityNodeInfo1.isContentInvalid());
      paramAccessibilityNodeInfo2.setDismissable(paramAccessibilityNodeInfo1.isDismissable());
      paramAccessibilityNodeInfo2.setInputType(paramAccessibilityNodeInfo1.getInputType());
      paramAccessibilityNodeInfo2.setLiveRegion(paramAccessibilityNodeInfo1.getLiveRegion());
      paramAccessibilityNodeInfo2.setMultiLine(paramAccessibilityNodeInfo1.isMultiLine());
      paramAccessibilityNodeInfo2.setRangeInfo(paramAccessibilityNodeInfo1.getRangeInfo());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramAccessibilityNodeInfo2.setError(paramAccessibilityNodeInfo1.getError());
      paramAccessibilityNodeInfo2.setMaxTextLength(paramAccessibilityNodeInfo1.getMaxTextLength());
    }
    if (Build.VERSION.SDK_INT >= 23) {
      paramAccessibilityNodeInfo2.setContextClickable(paramAccessibilityNodeInfo1.isContextClickable());
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramAccessibilityNodeInfo2.setDrawingOrder(paramAccessibilityNodeInfo1.getDrawingOrder());
      paramAccessibilityNodeInfo2.setImportantForAccessibility(paramAccessibilityNodeInfo1.isImportantForAccessibility());
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramAccessibilityNodeInfo2.setAvailableExtraData(paramAccessibilityNodeInfo1.getAvailableExtraData());
      paramAccessibilityNodeInfo2.setHintText(paramAccessibilityNodeInfo1.getHintText());
      paramAccessibilityNodeInfo2.setShowingHintText(paramAccessibilityNodeInfo1.isShowingHintText());
    }
  }
  
  private void setFlutterNodeParent(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull View paramView, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    paramAccessibilityNodeInfo1 = this.reflectionAccessors.getParentNodeId(paramAccessibilityNodeInfo1);
    if (paramAccessibilityNodeInfo1 == null) {}
    do
    {
      return;
      int i = ReflectionAccessors.getVirtualNodeId(paramAccessibilityNodeInfo1.longValue());
      paramAccessibilityNodeInfo1 = (Integer)this.originToFlutterId.get(new ViewAndId(paramView, i, null));
    } while (paramAccessibilityNodeInfo1 == null);
    paramAccessibilityNodeInfo2.setParent(this.rootAccessibilityView, paramAccessibilityNodeInfo1.intValue());
  }
  
  private void setFlutterNodesTranslateBounds(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo1, @NonNull Rect paramRect, @NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    Rect localRect = new Rect();
    paramAccessibilityNodeInfo1.getBoundsInScreen(localRect);
    localRect.offset(paramRect.left, paramRect.top);
    paramAccessibilityNodeInfo2.setBoundsInScreen(localRect);
  }
  
  @Nullable
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    ViewAndId localViewAndId = (ViewAndId)this.flutterIdToOrigin.get(paramInt);
    if (localViewAndId == null) {
      return null;
    }
    if (!this.embeddedViewToDisplayBounds.containsKey(localViewAndId.view)) {
      return null;
    }
    if (localViewAndId.view.getAccessibilityNodeProvider() == null) {
      return null;
    }
    AccessibilityNodeInfo localAccessibilityNodeInfo = localViewAndId.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(localViewAndId.id);
    if (localAccessibilityNodeInfo == null) {
      return null;
    }
    return convertToFlutterNode(localAccessibilityNodeInfo, paramInt, localViewAndId.view);
  }
  
  @Nullable
  public Integer getRecordFlutterId(@NonNull View paramView, @NonNull AccessibilityRecord paramAccessibilityRecord)
  {
    paramAccessibilityRecord = this.reflectionAccessors.getRecordSourceNodeId(paramAccessibilityRecord);
    if (paramAccessibilityRecord == null) {
      return null;
    }
    int i = ReflectionAccessors.getVirtualNodeId(paramAccessibilityRecord.longValue());
    return (Integer)this.originToFlutterId.get(new ViewAndId(paramView, i, null));
  }
  
  public AccessibilityNodeInfo getRootNode(@NonNull View paramView, int paramInt, @NonNull Rect paramRect)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = paramView.createAccessibilityNodeInfo();
    Long localLong = this.reflectionAccessors.getSourceNodeId(localAccessibilityNodeInfo);
    if (localLong == null) {
      return null;
    }
    this.embeddedViewToDisplayBounds.put(paramView, paramRect);
    cacheVirtualIdMappings(paramView, ReflectionAccessors.getVirtualNodeId(localLong.longValue()), paramInt);
    return convertToFlutterNode(localAccessibilityNodeInfo, paramInt, paramView);
  }
  
  public boolean onAccessibilityHoverEvent(int paramInt, @NonNull MotionEvent paramMotionEvent)
  {
    ViewAndId localViewAndId = (ViewAndId)this.flutterIdToOrigin.get(paramInt);
    paramInt = 0;
    if (localViewAndId == null) {
      return false;
    }
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(localViewAndId.view);
    int i = paramMotionEvent.getPointerCount();
    MotionEvent.PointerProperties[] arrayOfPointerProperties = new MotionEvent.PointerProperties[i];
    MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[i];
    while (paramInt < paramMotionEvent.getPointerCount())
    {
      arrayOfPointerProperties[paramInt] = new MotionEvent.PointerProperties();
      paramMotionEvent.getPointerProperties(paramInt, arrayOfPointerProperties[paramInt]);
      MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
      paramMotionEvent.getPointerCoords(paramInt, localPointerCoords);
      arrayOfPointerCoords[paramInt] = new MotionEvent.PointerCoords(localPointerCoords);
      localPointerCoords = arrayOfPointerCoords[paramInt];
      localPointerCoords.x -= localRect.left;
      localPointerCoords = arrayOfPointerCoords[paramInt];
      localPointerCoords.y -= localRect.top;
      paramInt += 1;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), paramMotionEvent.getPointerCount(), arrayOfPointerProperties, arrayOfPointerCoords, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
    return localViewAndId.view.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, @Nullable Bundle paramBundle)
  {
    ViewAndId localViewAndId = (ViewAndId)this.flutterIdToOrigin.get(paramInt1);
    if (localViewAndId == null) {
      return false;
    }
    AccessibilityNodeProvider localAccessibilityNodeProvider = localViewAndId.view.getAccessibilityNodeProvider();
    if (localAccessibilityNodeProvider == null) {
      return false;
    }
    return localAccessibilityNodeProvider.performAction(localViewAndId.id, paramInt2, paramBundle);
  }
  
  public boolean requestSendAccessibilityEvent(@NonNull View paramView1, @NonNull View paramView2, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramAccessibilityEvent);
    Object localObject = this.reflectionAccessors.getRecordSourceNodeId(paramAccessibilityEvent);
    if (localObject == null) {
      return false;
    }
    int i = ReflectionAccessors.getVirtualNodeId(((Long)localObject).longValue());
    Integer localInteger = (Integer)this.originToFlutterId.get(new ViewAndId(paramView1, i, null));
    localObject = localInteger;
    int j;
    if (localInteger == null)
    {
      j = this.nextFlutterId;
      this.nextFlutterId = (j + 1);
      localObject = Integer.valueOf(j);
      cacheVirtualIdMappings(paramView1, i, ((Integer)localObject).intValue());
    }
    localAccessibilityEvent.setSource(this.rootAccessibilityView, ((Integer)localObject).intValue());
    localAccessibilityEvent.setClassName(paramAccessibilityEvent.getClassName());
    localAccessibilityEvent.setPackageName(paramAccessibilityEvent.getPackageName());
    i = 0;
    for (;;)
    {
      if (i >= localAccessibilityEvent.getRecordCount()) {
        break label239;
      }
      paramAccessibilityEvent = localAccessibilityEvent.getRecord(i);
      localObject = this.reflectionAccessors.getRecordSourceNodeId(paramAccessibilityEvent);
      if (localObject == null) {
        break;
      }
      localObject = new ViewAndId(paramView1, ReflectionAccessors.getVirtualNodeId(((Long)localObject).longValue()), null);
      if (!this.originToFlutterId.containsKey(localObject)) {
        break;
      }
      j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
      paramAccessibilityEvent.setSource(this.rootAccessibilityView, j);
      i += 1;
    }
    label239:
    return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(paramView2, localAccessibilityEvent);
  }
  
  static class ReflectionAccessors
  {
    @Nullable
    private final Field childNodeIdsField;
    @Nullable
    private final Method getChildId;
    @Nullable
    private final Method getParentNodeId;
    @Nullable
    private final Method getRecordSourceNodeId;
    @Nullable
    private final Method getSourceNodeId;
    @Nullable
    private final Method longArrayGetIndex;
    
    @SuppressLint({"PrivateApi"})
    private ReflectionAccessors()
    {
      for (;;)
      {
        Method localMethod4;
        Object localObject4;
        Field localField;
        Object localObject3;
        try
        {
          localMethod2 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          try
          {
            localMethod3 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            if (Build.VERSION.SDK_INT > 26) {}
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            try
            {
              localObject1 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
            }
            catch (NoSuchMethodException localNoSuchMethodException3)
            {
              try
              {
                Method localMethod1 = AccessibilityNodeInfo.class.getMethod("getChildId", new Class[] { Integer.TYPE });
                localMethod4 = null;
                localObject4 = localObject1;
                Object localObject1 = localMethod4;
                this.getSourceNodeId = localMethod2;
                this.getParentNodeId = localObject4;
                this.getRecordSourceNodeId = localMethod3;
                this.getChildId = localMethod1;
                this.childNodeIdsField = ((Field)localObject1);
                this.longArrayGetIndex = localObject5;
                return;
                localNoSuchMethodException1 = localNoSuchMethodException1;
                Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
                Method localMethod2 = null;
                continue;
                localNoSuchMethodException2 = localNoSuchMethodException2;
                Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
                Method localMethod3 = null;
                continue;
                localNoSuchMethodException3 = localNoSuchMethodException3;
                Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
                localField = null;
                continue;
              }
              catch (NoSuchMethodException localNoSuchMethodException5)
              {
                Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
                localObject3 = null;
                continue;
              }
            }
          }
        }
        try
        {
          localField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
          localField.setAccessible(true);
          localMethod4 = Class.forName("android.util.LongArray").getMethod("get", new Class[] { Integer.TYPE });
          localObject4 = null;
          localObject3 = null;
          localObject5 = localMethod4;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
          Object localObject2 = null;
          localObject3 = null;
          localObject4 = null;
        }
        catch (NullPointerException localNullPointerException)
        {
          break label218;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          break label218;
        }
        catch (NoSuchMethodException localNoSuchMethodException4)
        {
          label218:
          break label218;
        }
      }
    }
    
    @Nullable
    private Long getChildId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
    {
      if ((this.getChildId == null) && ((this.childNodeIdsField == null) || (this.longArrayGetIndex == null))) {
        return null;
      }
      if (this.getChildId != null) {}
      for (;;)
      {
        try
        {
          paramAccessibilityNodeInfo = (Long)this.getChildId.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
          return paramAccessibilityNodeInfo;
        }
        catch (InvocationTargetException paramAccessibilityNodeInfo)
        {
          Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
          return null;
        }
        catch (IllegalAccessException paramAccessibilityNodeInfo)
        {
          Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
          continue;
        }
        try
        {
          long l = ((Long)this.longArrayGetIndex.invoke(this.childNodeIdsField.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
          return Long.valueOf(l);
        }
        catch (ArrayIndexOutOfBoundsException paramAccessibilityNodeInfo)
        {
          Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
        }
        catch (IllegalAccessException paramAccessibilityNodeInfo)
        {
          Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
        }
        catch (InvocationTargetException paramAccessibilityNodeInfo)
        {
          label115:
          break label115;
        }
      }
    }
    
    @Nullable
    private Long getParentNodeId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      if (this.getParentNodeId != null) {}
      try
      {
        long l = ((Long)this.getParentNodeId.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
        return Long.valueOf(l);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.w("AccessibilityBridge", localInvocationTargetException);
        return yoinkParentIdFromParcel(paramAccessibilityNodeInfo);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.w("AccessibilityBridge", localIllegalAccessException);
        }
      }
    }
    
    @Nullable
    private Long getRecordSourceNodeId(@NonNull AccessibilityRecord paramAccessibilityRecord)
    {
      if (this.getRecordSourceNodeId == null) {
        return null;
      }
      try
      {
        paramAccessibilityRecord = (Long)this.getRecordSourceNodeId.invoke(paramAccessibilityRecord, new Object[0]);
        return paramAccessibilityRecord;
      }
      catch (InvocationTargetException paramAccessibilityRecord)
      {
        Log.w("AccessibilityBridge", paramAccessibilityRecord);
        return null;
      }
      catch (IllegalAccessException paramAccessibilityRecord)
      {
        for (;;)
        {
          Log.w("AccessibilityBridge", paramAccessibilityRecord);
        }
      }
    }
    
    @Nullable
    private Long getSourceNodeId(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      if (this.getSourceNodeId == null) {
        return null;
      }
      try
      {
        paramAccessibilityNodeInfo = (Long)this.getSourceNodeId.invoke(paramAccessibilityNodeInfo, new Object[0]);
        return paramAccessibilityNodeInfo;
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
        return null;
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        for (;;)
        {
          Log.w("AccessibilityBridge", paramAccessibilityNodeInfo);
        }
      }
    }
    
    private static int getVirtualNodeId(long paramLong)
    {
      return (int)(paramLong >> 32);
    }
    
    private static boolean isBitSet(long paramLong, int paramInt)
    {
      return (1L << paramInt & paramLong) != 0L;
    }
    
    @Nullable
    private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      Object localObject = null;
      if (Build.VERSION.SDK_INT < 26)
      {
        Log.w("AccessibilityBridge", "Unexpected Android version. Unable to find the parent ID.");
        return null;
      }
      paramAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
      Parcel localParcel = Parcel.obtain();
      localParcel.setDataPosition(0);
      paramAccessibilityNodeInfo.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      long l = localParcel.readLong();
      if (isBitSet(l, 0)) {
        localParcel.readInt();
      }
      if (isBitSet(l, 1)) {
        localParcel.readLong();
      }
      if (isBitSet(l, 2)) {
        localParcel.readInt();
      }
      paramAccessibilityNodeInfo = localObject;
      if (isBitSet(l, 3)) {
        paramAccessibilityNodeInfo = Long.valueOf(localParcel.readLong());
      }
      localParcel.recycle();
      return paramAccessibilityNodeInfo;
    }
  }
  
  static class ViewAndId
  {
    final int id;
    final View view;
    
    private ViewAndId(View paramView, int paramInt)
    {
      this.view = paramView;
      this.id = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (ViewAndId)paramObject;
      } while ((this.id == paramObject.id) && (this.view.equals(paramObject.view)));
      return false;
    }
    
    public int hashCode()
    {
      return (this.view.hashCode() + 31) * 31 + this.id;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder
 * JD-Core Version:    0.7.0.1
 */