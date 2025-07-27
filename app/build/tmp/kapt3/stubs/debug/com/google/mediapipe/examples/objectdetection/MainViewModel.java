package com.google.mediapipe.examples.objectdetection;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020)H\u0014J\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\tJ\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\tJ\u000e\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\tJ\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020)R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u00118F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0013R#\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0013R\u000e\u0010\'\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_allValues", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "_delegate", "", "_maxResults", "_model", "_mqttMessages", "", "_tankTemperatures", "_threshold", "allValues", "Landroidx/lifecycle/LiveData;", "getAllValues", "()Landroidx/lifecycle/LiveData;", "brokerUri", "connected", "", "currentDelegate", "getCurrentDelegate", "()I", "currentMaxResults", "getCurrentMaxResults", "currentModel", "getCurrentModel", "currentThreshold", "getCurrentThreshold", "()F", "mqttClient", "Lorg/eclipse/paho/client/mqttv3/MqttClient;", "mqttMessages", "getMqttMessages", "tankTemperatures", "getTankTemperatures", "topic", "addMessage", "", "msg", "onCleared", "setDelegate", "delegate", "setMaxResults", "maxResults", "setModel", "model", "setThreshold", "threshold", "startMqtt", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private int _delegate = 0;
    private float _threshold = 0.8F;
    private int _maxResults = 3;
    private int _model = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _mqttMessages = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Float>> _tankTemperatures = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Float>> _allValues = null;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttClient mqttClient;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String brokerUri = "tcp://192.168.1.12:1883";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String topic = "mein/test/topic";
    private boolean connected = false;
    
    public MainViewModel() {
        super();
    }
    
    public final int getCurrentDelegate() {
        return 0;
    }
    
    public final float getCurrentThreshold() {
        return 0.0F;
    }
    
    public final int getCurrentMaxResults() {
        return 0;
    }
    
    public final int getCurrentModel() {
        return 0;
    }
    
    public final void setDelegate(int delegate) {
    }
    
    public final void setThreshold(float threshold) {
    }
    
    public final void setMaxResults(int maxResults) {
    }
    
    public final void setModel(int model) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getMqttMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.lang.Float>> getTankTemperatures() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.lang.Float>> getAllValues() {
        return null;
    }
    
    public final void startMqtt() {
    }
    
    private final void addMessage(java.lang.String msg) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}