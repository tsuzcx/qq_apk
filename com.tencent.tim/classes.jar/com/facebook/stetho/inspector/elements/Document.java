package com.facebook.stetho.inspector.elements;

import android.os.SystemClock;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class Document
  extends ThreadBoundProxy
{
  private AttributeListAccumulator mCachedAttributeAccumulator;
  private ChildEventingList mCachedChildEventingList;
  private ArrayListAccumulator<Object> mCachedChildrenAccumulator;
  private final Queue<Object> mCachedUpdateQueue;
  private DocumentProvider mDocumentProvider;
  private final DocumentProviderFactory mFactory;
  private final ObjectIdMapper mObjectIdMapper;
  @GuardedBy("this")
  private int mReferenceCounter;
  private ShadowDocument mShadowDocument;
  private UpdateListenerCollection mUpdateListeners;
  
  public Document(DocumentProviderFactory paramDocumentProviderFactory)
  {
    super(paramDocumentProviderFactory);
    this.mFactory = paramDocumentProviderFactory;
    this.mObjectIdMapper = new DocumentObjectIdMapper(null);
    this.mReferenceCounter = 0;
    this.mUpdateListeners = new UpdateListenerCollection();
    this.mCachedUpdateQueue = new ArrayDeque();
  }
  
  private AttributeListAccumulator acquireCachedAttributeAccumulator()
  {
    AttributeListAccumulator localAttributeListAccumulator2 = this.mCachedAttributeAccumulator;
    AttributeListAccumulator localAttributeListAccumulator1 = localAttributeListAccumulator2;
    if (localAttributeListAccumulator2 == null) {
      localAttributeListAccumulator1 = new AttributeListAccumulator();
    }
    this.mCachedChildrenAccumulator = null;
    return localAttributeListAccumulator1;
  }
  
  private ChildEventingList acquireChildEventingList(Object paramObject, DocumentView paramDocumentView)
  {
    ChildEventingList localChildEventingList2 = this.mCachedChildEventingList;
    ChildEventingList localChildEventingList1 = localChildEventingList2;
    if (localChildEventingList2 == null) {
      localChildEventingList1 = new ChildEventingList(null);
    }
    this.mCachedChildEventingList = null;
    localChildEventingList1.acquire(paramObject, paramDocumentView);
    return localChildEventingList1;
  }
  
  private ArrayListAccumulator<Object> acquireChildrenAccumulator()
  {
    ArrayListAccumulator localArrayListAccumulator2 = this.mCachedChildrenAccumulator;
    ArrayListAccumulator localArrayListAccumulator1 = localArrayListAccumulator2;
    if (localArrayListAccumulator2 == null) {
      localArrayListAccumulator1 = new ArrayListAccumulator();
    }
    this.mCachedChildrenAccumulator = null;
    return localArrayListAccumulator1;
  }
  
  private void applyDocumentUpdate(ShadowDocument.Update paramUpdate)
  {
    paramUpdate.getGarbageElements(new Document.3(this, paramUpdate));
    paramUpdate.getChangedElements(new Document.4(this, paramUpdate));
    paramUpdate.getChangedElements(new Document.5(this, paramUpdate));
    paramUpdate.commit();
  }
  
  private void cleanUp()
  {
    this.mDocumentProvider.postAndWait(new Document.2(this));
    this.mUpdateListeners.clear();
  }
  
  private ShadowDocument.Update createShadowDocumentUpdate()
  {
    verifyThreadAccess();
    if (this.mDocumentProvider.getRootElement() != this.mShadowDocument.getRootElement()) {
      throw new IllegalStateException();
    }
    ArrayListAccumulator localArrayListAccumulator = acquireChildrenAccumulator();
    ShadowDocument.UpdateBuilder localUpdateBuilder = this.mShadowDocument.beginUpdate();
    this.mCachedUpdateQueue.add(this.mDocumentProvider.getRootElement());
    while (!this.mCachedUpdateQueue.isEmpty())
    {
      Object localObject1 = this.mCachedUpdateQueue.remove();
      NodeDescriptor localNodeDescriptor = this.mDocumentProvider.getNodeDescriptor(localObject1);
      this.mObjectIdMapper.putObject(localObject1);
      localNodeDescriptor.getChildren(localObject1, localArrayListAccumulator);
      int j = localArrayListAccumulator.size();
      int i = 0;
      if (i < j)
      {
        Object localObject2 = localArrayListAccumulator.get(i);
        if (localObject2 != null) {
          this.mCachedUpdateQueue.add(localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          LogUtil.e("%s.getChildren() emitted a null child at position %s for element %s", new Object[] { localNodeDescriptor.getClass().getName(), Integer.toString(i), localObject1 });
          localArrayListAccumulator.remove(i);
          i -= 1;
          j -= 1;
        }
      }
      localUpdateBuilder.setElementChildren(localObject1, localArrayListAccumulator);
      localArrayListAccumulator.clear();
    }
    releaseChildrenAccumulator(localArrayListAccumulator);
    return localUpdateBuilder.build();
  }
  
  private boolean doesElementMatch(Object paramObject, Pattern paramPattern)
  {
    AttributeListAccumulator localAttributeListAccumulator = acquireCachedAttributeAccumulator();
    NodeDescriptor localNodeDescriptor = this.mDocumentProvider.getNodeDescriptor(paramObject);
    localNodeDescriptor.getAttributes(paramObject, localAttributeListAccumulator);
    int j = localAttributeListAccumulator.size();
    int i = 0;
    while (i < j)
    {
      if (paramPattern.matcher((CharSequence)localAttributeListAccumulator.get(i)).find())
      {
        releaseCachedAttributeAccumulator(localAttributeListAccumulator);
        return true;
      }
      i += 1;
    }
    releaseCachedAttributeAccumulator(localAttributeListAccumulator);
    return paramPattern.matcher(localNodeDescriptor.getNodeName(paramObject)).find();
  }
  
  private void findMatches(Object paramObject, Pattern paramPattern, Accumulator<Integer> paramAccumulator)
  {
    paramObject = this.mShadowDocument.getElementInfo(paramObject);
    int i = 0;
    int j = paramObject.children.size();
    while (i < j)
    {
      Object localObject = paramObject.children.get(i);
      if (doesElementMatch(localObject, paramPattern)) {
        paramAccumulator.store(this.mObjectIdMapper.getIdForObject(localObject));
      }
      findMatches(localObject, paramPattern, paramAccumulator);
      i += 1;
    }
  }
  
  private void init()
  {
    this.mDocumentProvider = this.mFactory.create();
    this.mDocumentProvider.postAndWait(new Document.1(this));
  }
  
  private void releaseCachedAttributeAccumulator(AttributeListAccumulator paramAttributeListAccumulator)
  {
    paramAttributeListAccumulator.clear();
    if (this.mCachedAttributeAccumulator == null) {
      this.mCachedAttributeAccumulator = paramAttributeListAccumulator;
    }
  }
  
  private void releaseChildEventingList(ChildEventingList paramChildEventingList)
  {
    paramChildEventingList.release();
    if (this.mCachedChildEventingList == null) {
      this.mCachedChildEventingList = paramChildEventingList;
    }
  }
  
  private void releaseChildrenAccumulator(ArrayListAccumulator<Object> paramArrayListAccumulator)
  {
    paramArrayListAccumulator.clear();
    if (this.mCachedChildrenAccumulator == null) {
      this.mCachedChildrenAccumulator = paramArrayListAccumulator;
    }
  }
  
  private static void updateListenerChildren(ChildEventingList paramChildEventingList, List<Object> paramList, Accumulator<Object> paramAccumulator)
  {
    int i = 0;
    for (;;)
    {
      if (i <= paramChildEventingList.size())
      {
        if (i != paramChildEventingList.size()) {
          break label49;
        }
        if (i != paramList.size()) {}
      }
      else
      {
        return;
      }
      paramChildEventingList.addWithEvent(i, paramList.get(i), paramAccumulator);
      i += 1;
      continue;
      label49:
      if (i == paramList.size())
      {
        paramChildEventingList.removeWithEvent(i);
      }
      else
      {
        Object localObject1 = paramChildEventingList.get(i);
        Object localObject2 = paramList.get(i);
        if (localObject1 == localObject2)
        {
          i += 1;
        }
        else
        {
          int j = paramChildEventingList.indexOf(localObject2);
          if (j == -1)
          {
            paramChildEventingList.addWithEvent(i, localObject2, paramAccumulator);
            i += 1;
          }
          else
          {
            paramChildEventingList.removeWithEvent(j);
            paramChildEventingList.addWithEvent(i, localObject2, paramAccumulator);
            i += 1;
          }
        }
      }
    }
  }
  
  private void updateTree()
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject = createShadowDocumentUpdate();
    boolean bool = ((ShadowDocument.Update)localObject).isEmpty();
    String str;
    if (bool)
    {
      ((ShadowDocument.Update)localObject).abandon();
      str = Long.toString(SystemClock.elapsedRealtime() - l);
      if (!bool) {
        break label74;
      }
    }
    label74:
    for (localObject = " (no changes)";; localObject = "")
    {
      LogUtil.d("Document.updateTree() completed in %s ms%s", new Object[] { str, localObject });
      return;
      applyDocumentUpdate((ShadowDocument.Update)localObject);
      break;
    }
  }
  
  public void addRef()
  {
    try
    {
      int i = this.mReferenceCounter;
      this.mReferenceCounter = (i + 1);
      if (i == 0) {
        init();
      }
      return;
    }
    finally {}
  }
  
  public void addUpdateListener(UpdateListener paramUpdateListener)
  {
    this.mUpdateListeners.add(paramUpdateListener);
  }
  
  public void findMatchingElements(String paramString, Accumulator<Integer> paramAccumulator)
  {
    verifyThreadAccess();
    paramString = Pattern.compile(Pattern.quote(paramString), 2);
    findMatches(this.mDocumentProvider.getRootElement(), paramString, paramAccumulator);
  }
  
  public DocumentView getDocumentView()
  {
    verifyThreadAccess();
    return this.mShadowDocument;
  }
  
  public void getElementAccessibilityStyles(Object paramObject, StyleAccumulator paramStyleAccumulator)
  {
    getNodeDescriptor(paramObject).getAccessibilityStyles(paramObject, paramStyleAccumulator);
  }
  
  @Nullable
  public Object getElementForNodeId(int paramInt)
  {
    return this.mObjectIdMapper.getObjectForId(paramInt);
  }
  
  public void getElementStyles(Object paramObject, StyleAccumulator paramStyleAccumulator)
  {
    getNodeDescriptor(paramObject).getStyles(paramObject, paramStyleAccumulator);
  }
  
  @Nullable
  public NodeDescriptor getNodeDescriptor(Object paramObject)
  {
    verifyThreadAccess();
    return this.mDocumentProvider.getNodeDescriptor(paramObject);
  }
  
  @Nullable
  public Integer getNodeIdForElement(Object paramObject)
  {
    return this.mObjectIdMapper.getIdForObject(paramObject);
  }
  
  public Object getRootElement()
  {
    verifyThreadAccess();
    Object localObject = this.mDocumentProvider.getRootElement();
    if (localObject == null) {
      throw new IllegalStateException();
    }
    if (localObject != this.mShadowDocument.getRootElement()) {
      throw new IllegalStateException();
    }
    return localObject;
  }
  
  public void hideHighlight()
  {
    verifyThreadAccess();
    this.mDocumentProvider.hideHighlight();
  }
  
  public void highlightElement(Object paramObject, int paramInt)
  {
    verifyThreadAccess();
    this.mDocumentProvider.highlightElement(paramObject, paramInt);
  }
  
  public void release()
  {
    try
    {
      if (this.mReferenceCounter > 0)
      {
        int i = this.mReferenceCounter - 1;
        this.mReferenceCounter = i;
        if (i == 0) {
          cleanUp();
        }
      }
      return;
    }
    finally {}
  }
  
  public void removeUpdateListener(UpdateListener paramUpdateListener)
  {
    this.mUpdateListeners.remove(paramUpdateListener);
  }
  
  public void setAttributesAsText(Object paramObject, String paramString)
  {
    verifyThreadAccess();
    this.mDocumentProvider.setAttributesAsText(paramObject, paramString);
  }
  
  public void setInspectModeEnabled(boolean paramBoolean)
  {
    verifyThreadAccess();
    this.mDocumentProvider.setInspectModeEnabled(paramBoolean);
  }
  
  public static final class AttributeListAccumulator
    extends ArrayList<String>
    implements AttributeAccumulator
  {
    public void store(String paramString1, String paramString2)
    {
      add(paramString1);
      add(paramString2);
    }
  }
  
  final class ChildEventingList
    extends ArrayList<Object>
  {
    private DocumentView mDocumentView;
    private Object mParentElement = null;
    private int mParentNodeId = -1;
    
    private ChildEventingList() {}
    
    public void acquire(Object paramObject, DocumentView paramDocumentView)
    {
      this.mParentElement = paramObject;
      if (this.mParentElement == null) {}
      for (int i = -1;; i = Document.this.mObjectIdMapper.getIdForObject(this.mParentElement).intValue())
      {
        this.mParentNodeId = i;
        this.mDocumentView = paramDocumentView;
        return;
      }
    }
    
    public void addWithEvent(int paramInt, Object paramObject, Accumulator<Object> paramAccumulator)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = null;
        if (localObject != null) {
          break label56;
        }
      }
      label56:
      for (int i = -1;; i = Document.this.mObjectIdMapper.getIdForObject(localObject).intValue())
      {
        add(paramInt, paramObject);
        Document.this.mUpdateListeners.onChildNodeInserted(this.mDocumentView, paramObject, this.mParentNodeId, i, paramAccumulator);
        return;
        localObject = get(paramInt - 1);
        break;
      }
    }
    
    public void release()
    {
      clear();
      this.mParentElement = null;
      this.mParentNodeId = -1;
      this.mDocumentView = null;
    }
    
    public void removeWithEvent(int paramInt)
    {
      Object localObject = remove(paramInt);
      paramInt = Document.this.mObjectIdMapper.getIdForObject(localObject).intValue();
      Document.this.mUpdateListeners.onChildNodeRemoved(this.mParentNodeId, paramInt);
    }
  }
  
  final class DocumentObjectIdMapper
    extends ObjectIdMapper
  {
    private DocumentObjectIdMapper() {}
    
    public void onMapped(Object paramObject, int paramInt)
    {
      Document.this.verifyThreadAccess();
      Document.this.mDocumentProvider.getNodeDescriptor(paramObject).hook(paramObject);
    }
    
    public void onUnmapped(Object paramObject, int paramInt)
    {
      Document.this.verifyThreadAccess();
      Document.this.mDocumentProvider.getNodeDescriptor(paramObject).unhook(paramObject);
    }
  }
  
  final class ProviderListener
    implements DocumentProviderListener
  {
    private ProviderListener() {}
    
    public void onAttributeModified(Object paramObject, String paramString1, String paramString2)
    {
      Document.this.verifyThreadAccess();
      Document.this.mUpdateListeners.onAttributeModified(paramObject, paramString1, paramString2);
    }
    
    public void onAttributeRemoved(Object paramObject, String paramString)
    {
      Document.this.verifyThreadAccess();
      Document.this.mUpdateListeners.onAttributeRemoved(paramObject, paramString);
    }
    
    public void onInspectRequested(Object paramObject)
    {
      Document.this.verifyThreadAccess();
      Document.this.mUpdateListeners.onInspectRequested(paramObject);
    }
    
    public void onPossiblyChanged()
    {
      Document.this.updateTree();
    }
  }
  
  public static abstract interface UpdateListener
  {
    public abstract void onAttributeModified(Object paramObject, String paramString1, String paramString2);
    
    public abstract void onAttributeRemoved(Object paramObject, String paramString);
    
    public abstract void onChildNodeInserted(DocumentView paramDocumentView, Object paramObject, int paramInt1, int paramInt2, Accumulator<Object> paramAccumulator);
    
    public abstract void onChildNodeRemoved(int paramInt1, int paramInt2);
    
    public abstract void onInspectRequested(Object paramObject);
  }
  
  class UpdateListenerCollection
    implements Document.UpdateListener
  {
    private final List<Document.UpdateListener> mListeners = new ArrayList();
    private volatile Document.UpdateListener[] mListenersSnapshot;
    
    public UpdateListenerCollection() {}
    
    private Document.UpdateListener[] getListenersSnapshot()
    {
      for (;;)
      {
        Document.UpdateListener[] arrayOfUpdateListener = this.mListenersSnapshot;
        if (arrayOfUpdateListener != null) {
          return arrayOfUpdateListener;
        }
        try
        {
          if (this.mListenersSnapshot == null)
          {
            this.mListenersSnapshot = ((Document.UpdateListener[])this.mListeners.toArray(new Document.UpdateListener[this.mListeners.size()]));
            arrayOfUpdateListener = this.mListenersSnapshot;
            return arrayOfUpdateListener;
          }
        }
        finally {}
      }
    }
    
    public void add(Document.UpdateListener paramUpdateListener)
    {
      try
      {
        this.mListeners.add(paramUpdateListener);
        this.mListenersSnapshot = null;
        return;
      }
      finally
      {
        paramUpdateListener = finally;
        throw paramUpdateListener;
      }
    }
    
    public void clear()
    {
      try
      {
        this.mListeners.clear();
        this.mListenersSnapshot = null;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void onAttributeModified(Object paramObject, String paramString1, String paramString2)
    {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUpdateListener[i].onAttributeModified(paramObject, paramString1, paramString2);
        i += 1;
      }
    }
    
    public void onAttributeRemoved(Object paramObject, String paramString)
    {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUpdateListener[i].onAttributeRemoved(paramObject, paramString);
        i += 1;
      }
    }
    
    public void onChildNodeInserted(DocumentView paramDocumentView, Object paramObject, int paramInt1, int paramInt2, Accumulator<Object> paramAccumulator)
    {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUpdateListener[i].onChildNodeInserted(paramDocumentView, paramObject, paramInt1, paramInt2, paramAccumulator);
        i += 1;
      }
    }
    
    public void onChildNodeRemoved(int paramInt1, int paramInt2)
    {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUpdateListener[i].onChildNodeRemoved(paramInt1, paramInt2);
        i += 1;
      }
    }
    
    public void onInspectRequested(Object paramObject)
    {
      Document.UpdateListener[] arrayOfUpdateListener = getListenersSnapshot();
      int j = arrayOfUpdateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUpdateListener[i].onInspectRequested(paramObject);
        i += 1;
      }
    }
    
    public void remove(Document.UpdateListener paramUpdateListener)
    {
      try
      {
        this.mListeners.remove(paramUpdateListener);
        this.mListenersSnapshot = null;
        return;
      }
      finally
      {
        paramUpdateListener = finally;
        throw paramUpdateListener;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.Document
 * JD-Core Version:    0.7.0.1
 */