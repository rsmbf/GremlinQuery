/*
 * Copyright 2011 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel.socket.oio; 

import static io.netty.channel.Channels.*; 
import io.netty.channel.Channel; 
import io.netty.channel.ChannelFuture; 
import io.netty.channel.Channels; 
import io.netty.channel.socket.Worker; 
import io.netty.util.internal.QueueFactory; 

import java.io.IOException; 
import java.util.Queue; 

/**
 * Abstract base class for Oio-Worker implementations
 *
 * @param <C> {@link AbstractOioChannel}
 */
  class  AbstractOioWorker <C extends AbstractOioChannel>   {
	

    

	
    
    

	
    
    /**
     * If this worker has been started thread will be a reference to the thread
     * used when starting. i.e. the current thread when the run method is executed.
     */
    

	
    
    

	

    <<<<<<< /mnt/Vbox/FSTMerge/binary/fstmerge_tmp1390772202799/fstmerge_var1_5377231616530973092
@Override
    public void run() {
        thread = channel.workerThread = Thread.currentThread();

        while (channel.isOpen()) {
            synchronized (channel.interestOpsLock) {
                while (!channel.isReadable()) {
                    try {
                        // notify() is not called at all.
                        // close() and setInterestOps() calls Thread.interrupt()
                        channel.interestOpsLock.wait();
                    } catch (InterruptedException e) {
                        if (!channel.isOpen()) {
                            break;
                        }
                    }
                }
            }
            
            boolean cont = false;
            try {
                cont = process();

            } catch (Throwable t) {
                if (!channel.isSocketClosed()) {
                    fireExceptionCaught(channel, t);
                }
            } finally {
                processEventQueue();
                
                if (!cont) {
                    break;
                }
            }
        }

        // Setting the workerThread to null will prevent any channel
        // operations from interrupting this thread from now on.
        channel.workerThread = null;

        // Clean up.
        close(channel, succeededFuture(channel), true);
        
        // Mark the worker event loop as done so we know that we need to run tasks directly and not queue them
        // See #287
        done = true; 
        
        // just to make we don't have something left
        processEventQueue(); 
        
    }
=======
>>>>>>> /mnt/Vbox/FSTMerge/binary/fstmerge_tmp1390772202799/fstmerge_var2_744158558219162288


	
    
    

	
    
    <<<<<<< /mnt/Vbox/FSTMerge/binary/fstmerge_tmp1390772202904/fstmerge_var1_6387942283633187922
@Override
    public void executeInIoThread(Runnable task) {
        // check if the current thread is the worker thread
        //
        // Also check if the event loop of the worker is complete. If so we need to run the task now. 
        // See #287
        if (Thread.currentThread() == thread || done) { 
            task.run();
        } else {
            boolean added = eventQueue.offer(task);
            
            if (added) {
                // as we set the SO_TIMEOUT to 1 second this task will get picked up in 1 second at latest
            } 
        }
    }
=======
>>>>>>> /mnt/Vbox/FSTMerge/binary/fstmerge_tmp1390772202904/fstmerge_var2_888632409893910544


	
    
    <<<<<<< /mnt/Vbox/FSTMerge/binary/fstmerge_tmp1390772202956/fstmerge_var1_179401225157671086
private void processEventQueue() {
        for (;;) {
            final Runnable task = eventQueue.poll();
            if (task == null) {
                break;
            }
            task.run();
        }
    }
=======
>>>>>>> /mnt/Vbox/FSTMerge/binary/fstmerge_tmp1390772202956/fstmerge_var2_4241822558463611533


	
    

    /**
     * Process the incoming messages and also is responsible for call {@link Channels#fireMessageReceived(Channel, Object)} once a message
     * was processed without errors. 
     * 
     * @return continue returns <code>true</code> as long as this worker should continue to try processing incoming messages
     * @throws IOException
     */
    

	
    
    

	
    
    

	
    
    

	

    private volatile boolean done;


}