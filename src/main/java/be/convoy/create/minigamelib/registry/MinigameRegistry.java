package be.convoy.create.minigamelib.registry;

import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public final class MinigameRegistry<T> {
    private final HashMap<Identifier, T> registers = new HashMap<>();

    private <K, V> HashMap<V, K> invert(HashMap<K, V> map) {
        HashMap<V, K> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            inverted.put(entry.getValue(), entry.getKey());
        }

        return inverted;
    }

    public static <T> MinigameRegistry<T> create() {
        return new MinigameRegistry<>();
    }

    public void register(Identifier identifier, T value) {
        this.registers.put(identifier, value);
    }

    public void remove(Identifier identifier) {
        this.registers.remove(identifier);
    }

    public void removeAll() {
        this.registers.clear();
    }

    public T get(Identifier identifier) {
        return this.registers.get(identifier);
    }

    public boolean containsKey(Identifier identifier) {
        return this.registers.containsKey(identifier);
    }

    public Set<Identifier> keySet() {
        return this.registers.keySet();
    }

    public Collection<T> values() {
        return this.registers.values();
    }

    public HashMap<Identifier, T> map() {
        return this.registers;
    }

    public Identifier getReversed(T value) {
        return invert(registers).get(value);
    }
}
