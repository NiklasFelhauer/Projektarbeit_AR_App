package com.google.mediapipe.examples.objectdetection.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/fragments/MQTTFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/google/mediapipe/examples/objectdetection/databinding/FragmentMqttBinding;", "binding", "getBinding", "()Lcom/google/mediapipe/examples/objectdetection/databinding/FragmentMqttBinding;", "brokerUri", "", "mqttClient", "Lorg/eclipse/paho/client/mqttv3/MqttClient;", "topic", "connectAndSubscribe", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "app_debug"})
public final class MQTTFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.google.mediapipe.examples.objectdetection.databinding.FragmentMqttBinding _binding;
    private org.eclipse.paho.client.mqttv3.MqttClient mqttClient;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String brokerUri = "tcp://broker.hivemq.com:1883";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String topic = "mein/test/topic";
    
    public MQTTFragment() {
        super();
    }
    
    private final com.google.mediapipe.examples.objectdetection.databinding.FragmentMqttBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void connectAndSubscribe() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}