package com.sapient.ConcurrentPackage;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicOperationClass {
    AtomicReference <Element> atomicReference = new AtomicReference<>(null);

    public void push(String value) {
        Element element = new Element(value);

        while (true) {
            Element oldHead = atomicReference.get();
            element.next = oldHead;

            if (atomicReference.compareAndSet(oldHead, element))
                return;
        }
    }

    private class Element {
        private String value;
        private Element next;

        private Element (String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        AtomicOperationClass aClass = new AtomicOperationClass();
        aClass.push("abcdsd");
    }
}
