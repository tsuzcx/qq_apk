package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class ShadowDocument
  implements DocumentView
{
  private final IdentityHashMap<Object, ElementInfo> mElementToInfoMap = new IdentityHashMap();
  private boolean mIsUpdating;
  private final Object mRootElement;
  
  public ShadowDocument(Object paramObject)
  {
    this.mRootElement = Util.throwIfNull(paramObject);
  }
  
  public UpdateBuilder beginUpdate()
  {
    if (this.mIsUpdating) {
      throw new IllegalStateException();
    }
    this.mIsUpdating = true;
    return new UpdateBuilder();
  }
  
  public ElementInfo getElementInfo(Object paramObject)
  {
    return (ElementInfo)this.mElementToInfoMap.get(paramObject);
  }
  
  public Object getRootElement()
  {
    return this.mRootElement;
  }
  
  public final class Update
    implements DocumentView
  {
    private final Map<Object, ElementInfo> mElementToInfoChangesMap;
    private final Set<Object> mRootElementChangesSet;
    
    public Update(Set<Object> paramSet)
    {
      this.mElementToInfoChangesMap = paramSet;
      Object localObject;
      this.mRootElementChangesSet = localObject;
    }
    
    private void removeSubTree(Map<Object, ElementInfo> paramMap, Object paramObject)
    {
      ElementInfo localElementInfo = (ElementInfo)paramMap.get(paramObject);
      paramMap.remove(paramObject);
      int i = 0;
      int j = localElementInfo.children.size();
      while (i < j)
      {
        removeSubTree(paramMap, localElementInfo.children.get(i));
        i += 1;
      }
    }
    
    public void abandon()
    {
      if (!ShadowDocument.this.mIsUpdating) {
        throw new IllegalStateException();
      }
      ShadowDocument.access$202(ShadowDocument.this, false);
    }
    
    public void commit()
    {
      if (!ShadowDocument.this.mIsUpdating) {
        throw new IllegalStateException();
      }
      ShadowDocument.this.mElementToInfoMap.putAll(this.mElementToInfoChangesMap);
      Iterator localIterator = this.mRootElementChangesSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        removeSubTree(ShadowDocument.this.mElementToInfoMap, localObject);
      }
      ShadowDocument.access$202(ShadowDocument.this, false);
    }
    
    public void getChangedElements(Accumulator<Object> paramAccumulator)
    {
      Iterator localIterator = this.mElementToInfoChangesMap.keySet().iterator();
      while (localIterator.hasNext()) {
        paramAccumulator.store(localIterator.next());
      }
    }
    
    public ElementInfo getElementInfo(Object paramObject)
    {
      ElementInfo localElementInfo = (ElementInfo)this.mElementToInfoChangesMap.get(paramObject);
      if (localElementInfo != null) {
        return localElementInfo;
      }
      return (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(paramObject);
    }
    
    public void getGarbageElements(Accumulator<Object> paramAccumulator)
    {
      ArrayDeque localArrayDeque = new ArrayDeque();
      Object localObject1 = this.mRootElementChangesSet.iterator();
      Object localObject2;
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = getElementInfo(localObject2);
        if ((localObject2 != ShadowDocument.this.mRootElement) && (((ElementInfo)localObject3).parentElement == null))
        {
          localArrayDeque.add(localObject2);
          localArrayDeque.add(localObject2);
        }
      }
      while (!localArrayDeque.isEmpty())
      {
        localObject3 = localArrayDeque.remove();
        localObject2 = localArrayDeque.remove();
        localObject1 = localObject2;
        if (localObject3 == localObject2) {
          localObject1 = null;
        }
        if (getElementInfo(localObject3).parentElement == localObject1)
        {
          paramAccumulator.store(localObject3);
          localObject1 = ShadowDocument.this.getElementInfo(localObject3);
          if (localObject1 != null)
          {
            int i = 0;
            int j = ((ElementInfo)localObject1).children.size();
            while (i < j)
            {
              localArrayDeque.add(((ElementInfo)localObject1).children.get(i));
              localArrayDeque.add(localObject3);
              i += 1;
            }
          }
        }
      }
    }
    
    public Object getRootElement()
    {
      return ShadowDocument.this.getRootElement();
    }
    
    public boolean isElementChanged(Object paramObject)
    {
      return this.mElementToInfoChangesMap.containsKey(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.mElementToInfoChangesMap.isEmpty();
    }
  }
  
  public final class UpdateBuilder
  {
    private HashSet<Object> mCachedNotNewChildrenSet;
    private final Map<Object, ElementInfo> mElementToInfoChangesMap = new LinkedHashMap();
    private final HashSet<Object> mRootElementChanges = new HashSet();
    
    public UpdateBuilder() {}
    
    private HashSet<Object> acquireNotNewChildrenHashSet()
    {
      HashSet localHashSet2 = this.mCachedNotNewChildrenSet;
      HashSet localHashSet1 = localHashSet2;
      if (localHashSet2 == null) {
        localHashSet1 = new HashSet();
      }
      this.mCachedNotNewChildrenSet = null;
      return localHashSet1;
    }
    
    private void releaseNotNewChildrenHashSet(HashSet<Object> paramHashSet)
    {
      paramHashSet.clear();
      if (this.mCachedNotNewChildrenSet == null) {
        this.mCachedNotNewChildrenSet = paramHashSet;
      }
    }
    
    private void setElementParent(Object paramObject1, Object paramObject2)
    {
      Object localObject = (ElementInfo)this.mElementToInfoChangesMap.get(paramObject1);
      if ((localObject != null) && (paramObject2 == ((ElementInfo)localObject).parentElement)) {}
      ElementInfo localElementInfo;
      do
      {
        do
        {
          return;
          localElementInfo = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(paramObject1);
        } while ((localObject == null) && (localElementInfo != null) && (paramObject2 == localElementInfo.parentElement));
        if ((localObject == null) || (localElementInfo == null) || (paramObject2 != localElementInfo.parentElement) || (!ListUtil.identityEquals(localElementInfo.children, ((ElementInfo)localObject).children))) {
          break;
        }
        this.mElementToInfoChangesMap.remove(paramObject1);
      } while (paramObject2 != null);
      this.mRootElementChanges.remove(paramObject1);
      return;
      if (localObject != null) {
        localObject = ((ElementInfo)localObject).children;
      }
      for (;;)
      {
        localObject = new ElementInfo(paramObject1, paramObject2, (List)localObject);
        this.mElementToInfoChangesMap.put(paramObject1, localObject);
        if (paramObject2 != null) {
          break;
        }
        this.mRootElementChanges.add(paramObject1);
        return;
        if (localElementInfo != null) {
          localObject = localElementInfo.children;
        } else {
          localObject = Collections.emptyList();
        }
      }
      this.mRootElementChanges.remove(paramObject1);
    }
    
    public ShadowDocument.Update build()
    {
      return new ShadowDocument.Update(ShadowDocument.this, this.mElementToInfoChangesMap, this.mRootElementChanges);
    }
    
    public void setElementChildren(Object paramObject, List<Object> paramList)
    {
      Object localObject2 = (ElementInfo)this.mElementToInfoChangesMap.get(paramObject);
      if ((localObject2 != null) && (ListUtil.identityEquals(paramList, ((ElementInfo)localObject2).children))) {}
      ElementInfo localElementInfo;
      do
      {
        return;
        localElementInfo = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(paramObject);
      } while ((localObject2 == null) && (localElementInfo != null) && (ListUtil.identityEquals(paramList, localElementInfo.children)));
      Object localObject1;
      if ((localObject2 != null) && (localElementInfo != null) && (localElementInfo.parentElement == ((ElementInfo)localObject2).parentElement) && (ListUtil.identityEquals(paramList, localElementInfo.children)))
      {
        paramList = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(paramObject);
        this.mElementToInfoChangesMap.remove(paramObject);
        localObject1 = acquireNotNewChildrenHashSet();
        if ((localElementInfo != null) && (localElementInfo.children != paramList.children))
        {
          j = localElementInfo.children.size();
          i = 0;
        }
      }
      else
      {
        while (i < j)
        {
          ((HashSet)localObject1).add(localElementInfo.children.get(i));
          i += 1;
          continue;
          if (localObject2 != null) {
            localObject1 = ((ElementInfo)localObject2).parentElement;
          }
          for (;;)
          {
            paramList = new ElementInfo(paramObject, localObject1, paramList);
            this.mElementToInfoChangesMap.put(paramObject, paramList);
            break;
            if (localElementInfo != null) {
              localObject1 = localElementInfo.parentElement;
            } else {
              localObject1 = null;
            }
          }
        }
      }
      if ((localObject2 != null) && (((ElementInfo)localObject2).children != paramList.children))
      {
        j = ((ElementInfo)localObject2).children.size();
        i = 0;
        while (i < j)
        {
          ((HashSet)localObject1).add(((ElementInfo)localObject2).children.get(i));
          i += 1;
        }
      }
      int j = paramList.children.size();
      int i = 0;
      while (i < j)
      {
        localObject2 = paramList.children.get(i);
        setElementParent(localObject2, paramObject);
        ((HashSet)localObject1).remove(localObject2);
        i += 1;
      }
      paramList = ((HashSet)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject2 = paramList.next();
        localElementInfo = (ElementInfo)this.mElementToInfoChangesMap.get(localObject2);
        if ((localElementInfo == null) || (localElementInfo.parentElement == paramObject))
        {
          localElementInfo = (ElementInfo)ShadowDocument.this.mElementToInfoMap.get(localObject2);
          if ((localElementInfo != null) && (localElementInfo.parentElement == paramObject)) {
            setElementParent(localObject2, null);
          }
        }
      }
      releaseNotNewChildrenHashSet((HashSet)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.ShadowDocument
 * JD-Core Version:    0.7.0.1
 */