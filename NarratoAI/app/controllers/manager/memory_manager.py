from queue import Queue
from typing import Dict

from app.controllers.manager.base_manager import TaskManager


class InMemoryTaskManager(TaskManager):
    def create_queue(self):
        return Queue()

    def enqueue(self, task: Dict):
        self.queue.put(task)

    def dequeue(self):
        return self.queue.get()

    def is_queue_empty(self):
        return self.queue.empty()
